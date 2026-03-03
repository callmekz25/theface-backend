package com.codewithkz.inventoryservice.dto;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InventoryCreateUpdateResponseDTO extends BaseDTO {
    private String productId;
    private int quantity;
}

