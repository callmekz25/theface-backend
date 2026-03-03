package com.codewithkz.orderservice.service.client;

import com.codewithkz.commonlibrary.response.ApiResponse;
import com.codewithkz.orderservice.dto.ProductCreateUpdateResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${rest.integrations.product-service}")
public interface ProductServiceIntegration {

    @GetMapping("/api/products/{id}")
    ApiResponse<ProductCreateUpdateResponseDTO> getById(@PathVariable String id);

}
