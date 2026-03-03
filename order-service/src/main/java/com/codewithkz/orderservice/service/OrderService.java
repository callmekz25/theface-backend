package com.codewithkz.orderservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.orderservice.model.Order;
import com.codewithkz.orderservice.model.OrderStatus;
import com.codewithkz.commonlibrary.event.InventoryReservedEvent;

public interface OrderService extends BaseService<Order, String> {
    void updateStatusOrder(String orderId, OrderStatus status);
    void handleCreatePaymentCommand(InventoryReservedEvent event);
}
