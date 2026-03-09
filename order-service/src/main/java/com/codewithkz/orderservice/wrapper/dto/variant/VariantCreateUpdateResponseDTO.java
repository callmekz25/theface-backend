package com.codewithkz.orderservice.wrapper.dto.variant;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.orderservice.wrapper.dto.attribute.AttributeCreateUpdateResponseDTO;
import com.codewithkz.orderservice.wrapper.dto.productimage.ProductImageCreateUpdateResponseDTO;
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
public class VariantCreateUpdateResponseDTO extends BaseDTO {
    private String sku;
    private long price;
    private int quantity;
    private boolean isActive;
    private boolean isDefault;
    private List<ProductImageCreateUpdateResponseDTO> images;
    private List<AttributeCreateUpdateResponseDTO> attributes;
}