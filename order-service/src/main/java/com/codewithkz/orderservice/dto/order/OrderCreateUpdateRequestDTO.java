package com.codewithkz.orderservice.dto.order;

import com.codewithkz.commonlibrary.dto.BaseDTO;
import com.codewithkz.commonlibrary.model.OrderStatus;
import com.codewithkz.orderservice.dto.orderitem.OrderItemCreateUpdateRequestDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderCreateUpdateRequestDTO extends BaseDTO {
    private List<OrderItemCreateUpdateRequestDTO> orderItems;
    private OrderStatus status;
}
