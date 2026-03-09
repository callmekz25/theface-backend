package com.codewithkz.orderservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.orderservice.dto.orderitem.OrderItemCreateUpdateRequestDTO;
import com.codewithkz.orderservice.dto.orderitem.OrderItemCreateUpdateResponseDTO;
import com.codewithkz.orderservice.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper extends BaseMapper<OrderItem, OrderItemCreateUpdateRequestDTO, OrderItemCreateUpdateResponseDTO> {
}
