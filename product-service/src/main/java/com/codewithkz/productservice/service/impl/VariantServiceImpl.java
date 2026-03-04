package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.variant.VariantDTO;
import com.codewithkz.productservice.mapper.VariantMapper;
import com.codewithkz.productservice.model.Attribute;
import com.codewithkz.productservice.model.AttributeValue;
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.repository.VariantRepository;
import com.codewithkz.productservice.service.AttributeService;
import com.codewithkz.productservice.service.VariantService;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VariantServiceImpl extends BaseServiceImpl<Variant, VariantCreateUpdateRequestDTO, String> implements VariantService {
    private final VariantRepository repository;
    private final VariantMapper mapper;
    private final AttributeService attributeService;
    public VariantServiceImpl(VariantRepository repository, VariantMapper mapper, AttributeService attributeService) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.attributeService = attributeService;
    }

    @Override
    @Transactional
    public List<Variant> createList(List<Variant> variants) {
        return repository.saveAll(variants);
    }

    @Override
    @Transactional
    public List<Variant> createList(Product product, List<VariantDTO> variants) {
        List<Variant> variantList = new ArrayList<>();
        Map<String, Attribute> attributeMap = new HashMap<>();
        Map<String, AttributeValue> attributeValueMap = new HashMap<>();
        for (VariantDTO variantDTO : variants) {
            VariantCreateUpdateRequestDTO dto = VariantCreateUpdateRequestDTO
                    .builder()
                    .sku(variantDTO.getSku())
                    .price(variantDTO.getPrice())
                    .isActive(variantDTO.isActive())
                    .build();
            Variant variant = mapper.toEntity(dto);
            variant.setProduct(product);
            if (variantDTO.getAttributes() != null && !variantDTO.getAttributes().isEmpty()) {

                List<AttributeValue> attributeValues = attributeService.createAttributeValueList(
                        product,
                        variantDTO.getAttributes(),
                        attributeMap,
                        attributeValueMap
                );

                variant.getAttributeValues().addAll(attributeValues);
            }
            variantList.add(variant);
        }

        return createList(variantList);
    }
}
