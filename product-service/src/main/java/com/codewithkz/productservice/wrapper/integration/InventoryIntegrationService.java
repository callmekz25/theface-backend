package com.codewithkz.productservice.wrapper.integration;

import com.codewithkz.productservice.wrapper.dto.inventory.InventoryCreateUpdateRequestDTO;
import com.codewithkz.productservice.wrapper.dto.inventory.InventoryCreateUpdateResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${rest.integrations.inventory-service}", url = "${rest.integrations.inventory-service}")
public interface InventoryIntegrationService {
    @PostMapping(value = "/inventories/batch")
    ResponseEntity<List<InventoryCreateUpdateResponseDTO>> createList(@RequestBody List<InventoryCreateUpdateRequestDTO> requests);
}
