package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.exception.NotFoundException;
import com.codewithkz.commonlibrary.model.InventoryStatus;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductSearchRequestDTO;
import com.codewithkz.productservice.mapper.ProductMapper;
import com.codewithkz.productservice.model.Collection;
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.model.ProductImage;
import com.codewithkz.productservice.model.Variant;
import com.codewithkz.productservice.repository.ProductRepository;
import com.codewithkz.productservice.service.*;
import com.codewithkz.productservice.wrapper.dto.inventory.InventoryCreateUpdateRequestDTO;
import com.codewithkz.productservice.wrapper.integration.InventoryIntegrationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductSearchRequestDTO, String> implements ProductService {
    private final VariantService variantService;
    private final ProductRepository repository;
    private final ProductImageService productImageService;
    private final CollectionService collectionService;
    private final InventoryIntegrationService inventoryIntegrationService;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper, VariantService variantService, ProductImageService productImageService, CollectionService collectionService, InventoryIntegrationService inventoryIntegrationService) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.variantService = variantService;
        this.productImageService = productImageService;
        this.collectionService = collectionService;
        this.inventoryIntegrationService = inventoryIntegrationService;
    }

    @Override
    public List<Product> getAll(ProductSearchRequestDTO request) {
        List<Product> products;
        if(request.getCollections() != null && !request.getCollections().isEmpty()) {
            List<Collection> collections = collectionService.getBySlugs(request.getCollections());
            List<String> collectionIds = new ArrayList<>();
            for (Collection collection : collections) {
                collectionIds.add(collection.getId());
            }
            products = repository.findByCollectionIds(collectionIds);
        } else {
            products = repository.findAll();
        }
        return loadVariantsAndImages(products);
    }


    @Override
    public Product getById(String id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        List<Product> products = loadVariantsAndImages(List.of(product));
        return products.get(0);
    }

    @Override
    @Transactional
    public Product create(Product entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public Product create(ProductCreateUpdateRequestDTO request) {
        Product product = mapper.toEntity(request);
        if(request.getCollectionIds() != null && !request.getCollectionIds().isEmpty()) {
            List<Collection> collections = collectionService.getByIds(request.getCollectionIds());
            if(collections != null && !collections.isEmpty()) {
                product.getCollections().addAll(collections);
            }
        }
        Product createdProduct = create(product);
        if(request.getVariants() != null && !request.getVariants().isEmpty()) {
            List<Variant> variants = variantService.createList(createdProduct, request.getVariants());
            if(variants != null && !variants.isEmpty()) {
                List<InventoryCreateUpdateRequestDTO> inventoryRequests = new ArrayList<>();
                for (int i = 0; i < variants.size(); i++) {
                    Variant variant = variants.get(i);
                    int quantity = request.getVariants().get(i).getQuantity();
                    InventoryCreateUpdateRequestDTO inventoryRequest = InventoryCreateUpdateRequestDTO
                            .builder()
                            .variantId(variant.getId())
                            .quantity(quantity)
                            .status(InventoryStatus.IN_STOCK)
                            .build();
                    inventoryRequests.add(inventoryRequest);
                }
                inventoryIntegrationService.createList(inventoryRequests);
            }

        }
        return createdProduct;
    }



    @Override
    public Product getBySlug(String slug) {
        Product product = repository.findBySlug(slug).orElseThrow(() -> new NotFoundException("Product not found with slug: " + slug));
        List<Product> products = loadVariantsAndImages(List.of(product));
        return products.get(0);
    }

    @Override
    public List<Product> createList(List<Product> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Product update(String s, Product entity) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    private List<Product> loadVariantsAndImages(List<Product> products) {
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
}
