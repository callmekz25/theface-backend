package com.codewithkz.productservice.wrapper.dto.inventory;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.commonlibrary.model.InventoryStatus;
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
public class InventoryCreateUpdateResponseDTO extends BaseDTO {
    private String variantId;
    private int quantity;
    private int reservedQuantity;
    private int soldQuantity;
    private InventoryStatus status;
}

