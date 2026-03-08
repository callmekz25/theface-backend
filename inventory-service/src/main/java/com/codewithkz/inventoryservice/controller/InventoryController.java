package com.codewithkz.inventoryservice.controller;


import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateRequestDTO;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateResponseDTO;
import com.codewithkz.inventoryservice.model.Inventory;
import com.codewithkz.inventoryservice.mapper.InventoryMapper;
import com.codewithkz.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/inventories")
public class InventoryController extends BaseController<Inventory, InventoryCreateUpdateRequestDTO, InventoryCreateUpdateResponseDTO, String, String> {

    public InventoryController(InventoryService service, InventoryMapper mapper) {
        super(service, mapper);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<InventoryCreateUpdateResponseDTO>> createList(@RequestBody List<InventoryCreateUpdateRequestDTO> requests) {
        List<Inventory> inventories = mapper.toEntityList(requests);
        List<Inventory> created = service.createList(inventories);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTOList(created));
    }

}
