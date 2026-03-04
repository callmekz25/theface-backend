package com.codewithkz.productservice.service;

import com.codewithkz.commonlibrary.model.BaseEntity;
import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.model.Product;

public interface ProductService extends BaseService<Product, ProductCreateUpdateRequestDTO, String> {
    Product create(ProductCreateUpdateRequestDTO request);
}
