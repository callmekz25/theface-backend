package com.codewithkz.orderservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import com.codewithkz.commonlibrary.model.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Order extends BaseEntity {
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "total_price")
    private long totalPrice;
    @Column(name = "total_items")
    private int totalItems;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @Builder.Default
    private List<OrderItem> orderItems = new ArrayList<>();
}
