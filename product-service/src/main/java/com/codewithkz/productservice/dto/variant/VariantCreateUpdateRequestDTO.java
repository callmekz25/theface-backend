package com.codewithkz.productservice.dto.variant;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VariantCreateUpdateRequestDTO extends BaseDTO {
    private String sku;
    private Long price;
    private boolean isActive;
}
