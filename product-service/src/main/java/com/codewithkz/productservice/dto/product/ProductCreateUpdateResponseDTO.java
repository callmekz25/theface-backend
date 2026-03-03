package com.codewithkz.productservice.dto.product;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductCreateUpdateResponseDTO extends BaseDTO {
    private String name;
    private int price;
    private int quantity;
}
