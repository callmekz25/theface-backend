package com.codewithkz.inventoryservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.inventoryservice.model.OutboxEvent;

public interface OutboxService extends BaseService<OutboxEvent, String> {
    void create(String topic, Object payload);
}
