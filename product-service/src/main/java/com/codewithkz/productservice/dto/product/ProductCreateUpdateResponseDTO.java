package com.codewithkz.productservice.dto.product;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.productservice.dto.attribute.AttributeCreateUpdateResponseDTO;
import com.codewithkz.productservice.dto.variant.VariantCreateUpdateResponseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductCreateUpdateResponseDTO extends BaseDTO {
    private String title;
    private String slug;
    private String description;
    private String origin;
    private List<VariantCreateUpdateResponseDTO> variants;
}
