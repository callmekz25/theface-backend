package com.codewithkz.inventoryservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import com.codewithkz.commonlibrary.model.InventoryStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table
@Data
@NoArgsConstructor
@SuperBuilder
public class Inventory extends BaseEntity {
    @Column(nullable = false, unique = true, name = "variant_id")
    private String variantId;
    private int quantity;
    @Column(name = "reserved_quantity")
    private int reservedQuantity;
    @Column(name = "sold_quantity")
    private int soldQuantity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;
}
