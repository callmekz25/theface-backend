package com.codewithkz.inventoryservice.controller;


import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateRequestDTO;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateResponseDTO;
import com.codewithkz.inventoryservice.model.Inventory;
import com.codewithkz.inventoryservice.mapper.InventoryMapper;
import com.codewithkz.inventoryservice.service.impl.InventoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/inventories")
public class InventoryController extends BaseController<Inventory, InventoryCreateUpdateRequestDTO, InventoryCreateUpdateResponseDTO, String, String> {

    public InventoryController(InventoryServiceImpl service, InventoryMapper mapper) {
        super(service, mapper);
    }

}
