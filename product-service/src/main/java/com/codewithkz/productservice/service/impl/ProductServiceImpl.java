package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.exception.NotFoundException;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.attributevalue.AttributeValueCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateResponseDTO;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateRequestDTO;
import com.codewithkz.productservice.mapper.AttributeMapper;
import com.codewithkz.productservice.mapper.AttributeValueMapper;
import com.codewithkz.productservice.mapper.ProductMapper;
import com.codewithkz.productservice.mapper.VariantMapper;
import com.codewithkz.productservice.model.Attribute;
import com.codewithkz.productservice.model.AttributeValue;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.repository.AttributeRepository;
import com.codewithkz.productservice.repository.AttributeValueRepository;
import com.codewithkz.productservice.repository.ProductRepository;
import com.codewithkz.productservice.repository.VariantRepository;
import com.codewithkz.productservice.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService<ProductCreateUpdateRequestDTO, ProductCreateUpdateResponseDTO, String> {
    private final ProductRepository repo;
    private final AttributeRepository attributeRepo;
    private final AttributeValueRepository attributeValueRepo;
    private final VariantRepository variantRepo;
    private final ProductMapper mapper;
    private final VariantMapper variantMapper;
    private final AttributeMapper attributeMapper;
    private final AttributeValueMapper attributeValueMapper;

    public ProductServiceImpl(ProductRepository repo, ProductMapper mapper, VariantMapper variantMapper, AttributeMapper attributeMapper, AttributeValueMapper attributeValueMapper, AttributeRepository attributeRepo, AttributeValueRepository attributeValueRepo, VariantRepository variantRepo) {
        this.repo = repo;
        this.attributeRepo = attributeRepo;
        this.attributeValueRepo = attributeValueRepo;
        this.variantRepo = variantRepo;
        this.mapper = mapper;
        this.variantMapper = variantMapper;
        this.attributeMapper = attributeMapper;
        this.attributeValueMapper = attributeValueMapper;
    }

    @Override
    public List<ProductCreateUpdateResponseDTO> getAll() {
        var products = repo.findAllVariants();
        var variantIds = new ArrayList<String>();
        products.forEach(p -> {
            p.getVariants().forEach(v -> {
                variantIds.add(v.getId());
            });
        });
        return mapper.toDTOList(products);
    }

    @Override
    public ProductCreateUpdateResponseDTO getById(String s) {
        return repo.findById(s).map(mapper::toDTO).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    @Transactional
    public ProductCreateUpdateResponseDTO create(ProductCreateUpdateRequestDTO request) {
        var product = mapper.toEntity(request);
        var createdProduct = repo.save(product);

        Map<String, Attribute> attributeMap = new HashMap<>();
        Map<String, AttributeValue> attributeValueMap = new HashMap<>();
        List<Variant> variants = new ArrayList<>();
        if(request.getVariants() != null && !request.getVariants().isEmpty()) {
            request.getVariants().forEach(v -> {
                // Create variant
                VariantCreateUpdateRequestDTO variantDTO = VariantCreateUpdateRequestDTO.builder()
                        .sku(v.getSku())
                        .price(v.getPrice())
                        .isActive(v.isActive())
                        .build();
                Variant variant = variantMapper.toEntity(variantDTO);
                variant.setProduct(createdProduct);
                var createdVariant = variantRepo.save(variant);

                // Create attributes and attribute values
                if(v.getAttributes() != null && !v.getAttributes().isEmpty()) {
                    // Avoid duplicate attributes
                    v.getAttributes().forEach(a -> {
                        // Attribute
                        Attribute attribute = attributeMap.get(a.getName());
                        if(attribute == null) {
                            AttributeCreateUpdateRequestDTO attributeDTO = AttributeCreateUpdateRequestDTO.builder()
                                    .name(a.getName())
                                    .build();
                            attribute = attributeMapper.toEntity(attributeDTO);
                            attribute.setProduct(createdProduct);
                            attribute = attributeRepo.save(attribute);
                            attributeMap.put(a.getName(), attribute);
                        }

                        // AttributeValue
                        String key = a.getName() + "_" + a.getValue();
                        AttributeValue attributeValue = attributeValueMap.get(key);
                        if(attributeValue == null) {
                            AttributeValueCreateUpdateRequestDTO attributeValueDTO = AttributeValueCreateUpdateRequestDTO.builder()
                                    .value(a.getValue())
                                    .build();
                            attributeValue = attributeValueMapper.toEntity(attributeValueDTO);
                            attributeValue.setAttribute(attribute);
                            attributeValue = attributeValueRepo.save(attributeValue);
                            attributeValueMap.put(key, attributeValue);
                        }
                        createdVariant.getAttributeValues().add(attributeValue);

                    });
                }
                variantRepo.save(createdVariant);
            });
        }
        variantRepo.saveAll(variants);
        return mapper.toDTO(createdProduct);
    }

    @Override
    @Transactional
    public List<ProductCreateUpdateResponseDTO> createList(List<ProductCreateUpdateRequestDTO> request) {
        var products = mapper.toEntityList(request);
        var createdList = repo.saveAll(products);
        return mapper.toDTOList(createdList);
    }

    @Override
    public ProductCreateUpdateResponseDTO update(String s, ProductCreateUpdateRequestDTO request) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
