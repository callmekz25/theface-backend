package com.codewithkz.productservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.model.ProductImage;
import com.codewithkz.productservice.model.Variant;

import java.util.List;

public interface ProductImageService extends BaseService<ProductImage, String, String> {
    List<ProductImage> getByVariantIds(List<String> variantIds);
    List<ProductImage> createList(Variant variant, List<ProductImage> entities);
}
