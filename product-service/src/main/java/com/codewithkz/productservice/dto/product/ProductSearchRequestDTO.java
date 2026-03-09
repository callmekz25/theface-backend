package com.codewithkz.productservice.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequestDTO {
    private List<String> collections;
}
