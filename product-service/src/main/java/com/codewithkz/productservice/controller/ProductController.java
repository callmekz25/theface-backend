package com.codewithkz.productservice.controller;

import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateResponseDTO;
import com.codewithkz.productservice.dto.product.ProductSearchRequestDTO;
import com.codewithkz.productservice.mapper.ProductMapper;
import com.codewithkz.productservice.model.Product;
import com.codewithkz.productservice.service.ProductService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController extends BaseController<Product, ProductCreateUpdateRequestDTO, ProductCreateUpdateResponseDTO, ProductSearchRequestDTO, String> {
    private final ProductService productService;
    private final ProductMapper productMapper;
    public ProductController(ProductService productService, ProductMapper productMapper) {
        super(productService, productMapper);
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProductCreateUpdateResponseDTO> create(@RequestBody ProductCreateUpdateRequestDTO requestDTO)
    {
        Product createdProduct = productService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toDTO(createdProduct));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<ProductCreateUpdateResponseDTO> getBySlug(@PathVariable("slug") String slug) {
        Product product = productService.getBySlug(slug);
        return ResponseEntity.ok(productMapper.toDTO(product));
    }
}
