package com.codewithkz.productservice.dto.attribute;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AttributeCreateUpdateRequestDTO extends BaseDTO {
    private String name;
    private String value;
}
