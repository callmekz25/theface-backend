package com.codewithkz.orderservice.wrapper.integration;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service")
public interface UserServiceIntegration {
}
