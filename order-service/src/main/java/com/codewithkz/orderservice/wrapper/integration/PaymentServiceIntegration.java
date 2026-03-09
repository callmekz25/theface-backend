package com.codewithkz.orderservice.wrapper.integration;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "payment-service")
public interface PaymentServiceIntegration {
}
