package com.codewithkz.orderservice.model;

import com.codewithkz.commonlibrary.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class OrderItem extends BaseEntity {
    @Column(name = "variant_id")
    private String variantId;
    private int quantity;
    private long price;
    @Column(name = "image_url")
    private String imageUrl;
    private String attribute;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
