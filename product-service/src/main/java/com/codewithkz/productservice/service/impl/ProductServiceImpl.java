package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.exception.NotFoundException;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
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
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.repository.AttributeRepository;
import com.codewithkz.productservice.repository.AttributeValueRepository;
import com.codewithkz.productservice.repository.ProductRepository;
import com.codewithkz.productservice.repository.VariantRepository;
import com.codewithkz.productservice.service.AttributeService;
import com.codewithkz.productservice.service.AttributeValueService;
import com.codewithkz.productservice.service.ProductService;
import com.codewithkz.productservice.service.VariantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductCreateUpdateRequestDTO, String> implements ProductService {
    private final ProductRepository repo;
    private VariantService variantService;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repo, ProductMapper mapper, VariantService variantService, AttributeService attributeService, AttributeValueService attributeValueService) {
        super(repo);
        this.repo = repo;
        this.mapper = mapper;
        this.variantService = variantService;
    }

    @Override
    public List<Product> getAll() {
        var products = repo.findAllVariants();
        return products;
    }

    @Override
    public Product getById(String id) {
        var product = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return product;
    }

    @Override
    public Product create(Product entity) {
        return repo.save(entity);
    }

    @Override
    public Product create(ProductCreateUpdateRequestDTO request) {
        Product product = mapper.toEntity(request);
        Product createdProduct = create(product);
        if(request.getVariants() != null && !request.getVariants().isEmpty()) {
            variantService.createList(createdProduct, request.getVariants());
        }
        return createdProduct;
    }

    @Override
    public List<Product> search(ProductCreateUpdateRequestDTO request) {
        return List.of();
    }

    @Override
    public List<Product> createList(List<Product> entities) {
        return repo.saveAll(entities);
    }

    @Override
    public Product update(String s, Product entity) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
