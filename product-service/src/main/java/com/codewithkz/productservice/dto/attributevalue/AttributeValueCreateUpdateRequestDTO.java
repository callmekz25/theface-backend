package com.codewithkz.productservice.dto.attributevalue;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AttributeValueCreateUpdateRequestDTO extends BaseDTO {
    private String value;
}
