package com.codewithkz.orderservice.dto.orderitem;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderItemCreateUpdateResponseDTO {
    private String variantId;
    private int quantity;
    private long price;
    private String imageUrl;
    private String attribute;
}
