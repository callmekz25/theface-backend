package com.codewithkz.productservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.productservice.model.Brand;
import org.springframework.stereotype.Service;

@Service
public interface BrandService extends BaseService<Brand, String, String> {
}
