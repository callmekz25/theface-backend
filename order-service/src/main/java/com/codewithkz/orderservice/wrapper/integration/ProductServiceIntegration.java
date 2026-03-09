package com.codewithkz.orderservice.wrapper.integration;

import com.codewithkz.orderservice.dto.ProductCreateUpdateResponseDTO;
import com.codewithkz.orderservice.wrapper.dto.variant.VariantCreateUpdateResponseDTO;
import com.codewithkz.orderservice.wrapper.dto.variant.VariantSearchRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${rest.integrations.product-service}")
public interface ProductServiceIntegration {
    @GetMapping("/products/{id}")
    ResponseEntity<ProductCreateUpdateResponseDTO> getProductById(@PathVariable String id);
    @GetMapping("/variants")
    ResponseEntity<List<VariantCreateUpdateResponseDTO>> getAllVariants(@RequestParam List<String> ids);

}
