package com.codewithkz.productservice.dto.variant;

import com.codewithkz.productservice.dto.attribute.AttributeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class VariantDTO {
    private String sku;
    private Long price;
    private int quantity;
    private boolean isActive;
    private List<AttributeDTO> attributes;
}
