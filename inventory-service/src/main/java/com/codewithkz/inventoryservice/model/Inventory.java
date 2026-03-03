package com.codewithkz.inventoryservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
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
    private String productId;
    private int quantity;
}
