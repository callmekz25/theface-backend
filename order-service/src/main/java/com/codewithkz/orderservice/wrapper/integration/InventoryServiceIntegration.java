package com.codewithkz.orderservice.wrapper.integration;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "inventory-service")
public interface InventoryServiceIntegration {
}
