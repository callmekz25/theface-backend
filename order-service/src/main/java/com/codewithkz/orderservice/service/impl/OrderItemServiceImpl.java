package com.codewithkz.orderservice.service.impl;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.orderservice.model.OrderItem;
import com.codewithkz.orderservice.repository.OrderItemRepository;
import com.codewithkz.orderservice.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem, String, String> implements OrderItemService {
    public OrderItemServiceImpl(OrderItemRepository repository) {
        super(repository);
    }
}
