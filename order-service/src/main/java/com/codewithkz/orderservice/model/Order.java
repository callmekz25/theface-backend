package com.codewithkz.orderservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Order extends BaseEntity {
    private String productId;
    private String userId;
    private int quantity;
    private Double price;
    private Double total;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
