package com.codewithkz.productservice.controller;

import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.product.ProductCreateUpdateResponseDTO;
import com.codewithkz.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController extends BaseController<ProductCreateUpdateRequestDTO, ProductCreateUpdateResponseDTO, String> {

    public ProductController(ProductService service) {
        super(service);
    }
}
