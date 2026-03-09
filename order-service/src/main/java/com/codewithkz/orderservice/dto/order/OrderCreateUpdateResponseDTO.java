package com.codewithkz.orderservice.dto.order;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.commonlibrary.model.OrderStatus;
import com.codewithkz.orderservice.dto.orderitem.OrderItemCreateUpdateResponseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderCreateUpdateResponseDTO extends BaseDTO {
    private List<OrderItemCreateUpdateResponseDTO> orderItems;
    private OrderStatus status;
    private String userId;
    private int totalItems;
    private long totalPrice;
}