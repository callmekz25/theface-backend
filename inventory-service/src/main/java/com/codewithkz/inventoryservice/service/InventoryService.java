package com.codewithkz.inventoryservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateRequestDTO;
import com.codewithkz.inventoryservice.model.Inventory;
import com.codewithkz.commonlibrary.event.OrderCreatedEvent;
import com.codewithkz.commonlibrary.event.PaymentFailedEvent;

public interface InventoryService extends BaseService<Inventory, String> {
    Inventory getByProductId(String id);
    Inventory validateStock(InventoryCreateUpdateRequestDTO dto);
    void handleInventoryReserve(OrderCreatedEvent event);
    void handlePaymentFailed(PaymentFailedEvent event);
}
