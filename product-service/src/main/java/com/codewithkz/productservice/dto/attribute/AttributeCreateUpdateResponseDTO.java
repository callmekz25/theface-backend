package com.codewithkz.productservice.dto.attribute;

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
public class AttributeCreateUpdateResponseDTO extends BaseDTO {
    private String name;
}
