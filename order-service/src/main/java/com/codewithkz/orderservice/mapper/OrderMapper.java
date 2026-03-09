package com.codewithkz.orderservice.mapper;


import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.orderservice.dto.order.OrderCreateUpdateRequestDTO;
import com.codewithkz.orderservice.dto.order.OrderCreateUpdateResponseDTO;
import com.codewithkz.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper extends BaseMapper<Order, OrderCreateUpdateRequestDTO, OrderCreateUpdateResponseDTO> {
}
