package com.codewithkz.productservice.service;

import com.codewithkz.commonlibrary.model.BaseEntity;
import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductSearchRequestDTO;
import com.codewithkz.productservice.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, ProductSearchRequestDTO, String> {
    Product create(ProductCreateUpdateRequestDTO request);
    Product getBySlug(String slug);
}
