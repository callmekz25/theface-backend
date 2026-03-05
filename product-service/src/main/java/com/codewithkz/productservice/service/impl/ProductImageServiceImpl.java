package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.model.ProductImage;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.repository.ProductImageRepository;
import com.codewithkz.productservice.service.ProductImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImage, String, String> implements ProductImageService {
    private final ProductImageRepository repository;

    public ProductImageServiceImpl(ProductImageRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<ProductImage> getByVariantIds(List<String> variantIds) {
        return repository.findByVariantIds(variantIds);
    }

    @Override
    @Transactional
    public List<ProductImage> createList(List<ProductImage> entities) {
        return repository.saveAll(entities);
    }

    @Transactional
    @Override
    public List<ProductImage> createList(Variant variant, List<ProductImage> entities) {
        entities.forEach(entity -> entity.setVariant(variant));
        return createList(entities);
    }
}
