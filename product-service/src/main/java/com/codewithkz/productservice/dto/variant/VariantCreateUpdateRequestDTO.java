package com.codewithkz.productservice.dto.variant;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.productimage.ProductImageCreateUpdateRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class VariantCreateUpdateRequestDTO extends BaseDTO {
    private String sku;
    private Long price;
    private boolean isActive;
    private List<ProductImageCreateUpdateRequestDTO> images;
    private List<AttributeCreateUpdateRequestDTO> attributes;
}
