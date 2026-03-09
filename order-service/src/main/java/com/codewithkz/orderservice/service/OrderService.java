package com.codewithkz.orderservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.orderservice.dto.order.OrderCreateUpdateRequestDTO;
import com.codewithkz.orderservice.model.Order;

public interface OrderService extends BaseService<Order, String, String> {
     Order create(OrderCreateUpdateRequestDTO request);
//    void updateStatusOrder(String orderId, OrderStatus status);
//    void handleCreatePaymentCommand(InventoryReservedEvent event);
}
