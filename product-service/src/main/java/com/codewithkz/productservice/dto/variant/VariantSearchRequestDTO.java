package com.codewithkz.productservice.dto.variant;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VariantSearchRequestDTO {
    private List<String> ids;
}
