package com.codewithkz.productservice.service.impl;

import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateResponseDTO;
import com.codewithkz.productservice.repository.ProductRepository;
import com.codewithkz.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService<ProductCreateUpdateRequestDTO, ProductCreateUpdateResponseDTO, String> {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<ProductCreateUpdateResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public ProductCreateUpdateResponseDTO getById(String s) {
        return null;
    }

    @Override
    public ProductCreateUpdateResponseDTO create(ProductCreateUpdateRequestDTO request) {
        return null;
    }

    @Override
    public ProductCreateUpdateResponseDTO update(String s, ProductCreateUpdateRequestDTO request) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
