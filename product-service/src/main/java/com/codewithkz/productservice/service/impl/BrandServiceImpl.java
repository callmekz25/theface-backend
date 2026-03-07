package com.codewithkz.productservice.service.impl;

import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.productservice.model.Brand;
import com.codewithkz.productservice.repository.BrandRepository;
import com.codewithkz.productservice.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand, String, String> implements BrandService {
    public BrandServiceImpl(BrandRepository repository) {
        super(repository);
    }
}
