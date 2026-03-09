package com.codewithkz.orderservice.wrapper.dto.variant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class VariantSearchRequestDTO {
    private List<String> ids;
}
