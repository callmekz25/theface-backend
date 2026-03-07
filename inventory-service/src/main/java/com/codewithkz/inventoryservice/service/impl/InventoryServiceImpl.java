package com.codewithkz.inventoryservice.service.impl;

import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.inventoryservice.model.Inventory;
import com.codewithkz.inventoryservice.repository.InventoryRepository;
import com.codewithkz.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl extends BaseServiceImpl<Inventory, String, String> implements InventoryService {

//    @Value("${app.kafka.topic.inventory-reserved}")
//    private String inventoryReservedTopic;
//    @Value("${app.kafka.topic.inventory-released}")
//    private String inventoryReleasedTopic;
//    @Value("${app.kafka.topic.inventory-rejected}")
//    private String inventoryRejectTopic;

    public InventoryServiceImpl(InventoryRepository repository) {
        super(repository);
    }



}
