package com.codewithkz.inventoryservice.dto;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.commonlibrary.model.InventoryStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InventoryCreateUpdateRequestDTO extends BaseDTO {
    private String variantId;
    private int quantity;
    private int reservedQuantity;
    private int soldQuantity;
    private InventoryStatus status;
}
