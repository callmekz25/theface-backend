package com.codewithkz.orderservice.dto.orderitem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemCreateUpdateRequestDTO {
    private String variantId;
    private int quantity;
    private String imageUrl;
    private String attribute;
}
