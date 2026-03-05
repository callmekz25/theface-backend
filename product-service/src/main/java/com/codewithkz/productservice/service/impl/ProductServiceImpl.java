package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.exception.NotFoundException;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.mapper.ProductMapper;
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.model.ProductImage;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.repository.ProductRepository;
import com.codewithkz.productservice.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductCreateUpdateRequestDTO, String> implements ProductService {
    private final ProductRepository repo;
    private final VariantService variantService;
    private final ProductImageService productImageService;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repo, ProductMapper mapper, VariantService variantService, ProductImageService productImageService) {
        super(repo);
        this.repo = repo;
        this.mapper = mapper;
        this.variantService = variantService;
        this.productImageService = productImageService;
    }

    @Override
    public List<Product> getAll() {
        var products = repo.findAll();
        List<String> productIds = new ArrayList<>();
        List<String> variantIds = new ArrayList<>();
        for (Product product : products) {
            productIds.add(product.getId());
        }
        List<Variant> variants = variantService.getByProductIds(productIds);
        for (Variant variant : variants) {
            variantIds.add(variant.getId());
        }
        List<ProductImage> images = productImageService.getByVariantIds(variantIds);
        Map<String, List<ProductImage>> imageMap = new HashMap<>();
        Map<String, List<Variant>> variantMap = new HashMap<>();
        for (ProductImage image : images) {
            String variantId = image.getVariant().getId();
            if(imageMap.containsKey(variantId)) {
                imageMap.get(variantId).add(image);
            } else {
                List<ProductImage> imageList = new ArrayList<>();
                imageList.add(image);
                imageMap.put(variantId, imageList);
            }
        }
        for (Variant variant : variants) {
            String variantId = variant.getId();
            List<ProductImage> imageList = imageMap.get(variantId);
            if(imageList != null && !imageList.isEmpty()) {
                variant.setImages(imageMap.get(variantId));
            }
            String productId = variant.getProduct().getId();
            if(variantMap.containsKey(productId)) {
                variantMap.get(productId).add(variant);
            } else {
                List<Variant> variantList = new ArrayList<>();
                variantList.add(variant);
                variantMap.put(productId, variantList);
            }
        }
        for (Product product : products) {
            if(variantMap.containsKey(product.getId())) {
                product.setVariants(variantMap.get(product.getId()));
            }
        }

        return products;
    }

    @Override
    public Product getById(String id) {
        var product = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return product;
    }

    @Override
    @Transactional
    public Product create(Product entity) {
        return repo.save(entity);
    }

    @Override
    @Transactional
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
