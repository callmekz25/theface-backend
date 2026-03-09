package com.codewithkz.orderservice.service.impl;

import com.codewithkz.commonlibrary.exception.NotFoundException;
import com.codewithkz.commonlibrary.model.OrderStatus;
import com.codewithkz.commonlibrary.service.impl.BaseServiceImpl;
import com.codewithkz.orderservice.dto.order.OrderCreateUpdateRequestDTO;
import com.codewithkz.orderservice.mapper.OrderItemMapper;
import com.codewithkz.orderservice.model.Order;
import com.codewithkz.orderservice.model.OrderItem;
import com.codewithkz.orderservice.service.OrderItemService;
import com.codewithkz.orderservice.wrapper.dto.variant.VariantCreateUpdateResponseDTO;
import com.codewithkz.orderservice.wrapper.dto.variant.VariantSearchRequestDTO;
import com.codewithkz.orderservice.wrapper.integration.ProductServiceIntegration;
import com.codewithkz.orderservice.repository.OrderRepository;
import com.codewithkz.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl extends BaseServiceImpl<Order, String, String> implements OrderService {

    private final ProductServiceIntegration productServiceIntegration;
    private final OrderRepository repository;
    private final OrderItemService orderItemService;
    private final OrderItemMapper orderItemMapper;
//    @Value("${app.kafka.topic.reserve-inventory-command}")
//    private String reserveInventoryTopicName;
//    @Value("${app.kafka.topic.create-payment-command}")
//    private String createPaymentTopicName;

    public OrderServiceImpl(OrderRepository repository, ProductServiceIntegration productServiceIntegration, OrderItemService orderItemService, OrderItemMapper orderItemMapper) {
        super(repository);
        this.repository = repository;
        this.productServiceIntegration = productServiceIntegration;
        this.orderItemService = orderItemService;
        this.orderItemMapper = orderItemMapper;
    }


    @Override
    @Transactional
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    @Transactional
    public Order create(OrderCreateUpdateRequestDTO request) {
        int totalItems = 0;
        long totalPrice = 0;
        List<OrderItem> orderItems = orderItemMapper.toEntityList(request.getOrderItems());
        List<String> variantIds = new ArrayList<>();
        for (OrderItem item : orderItems) {
            variantIds.add(item.getVariantId());
            totalItems += item.getQuantity();
        }
        Map<String, VariantCreateUpdateResponseDTO> variantMap = new HashMap<>();
        List<VariantCreateUpdateResponseDTO> variants = productServiceIntegration.getAllVariants(variantIds).getBody();
        for (VariantCreateUpdateResponseDTO variant : variants) {
            variantMap.put(variant.getId(), variant);
        }
        for (OrderItem item : orderItems) {
            VariantCreateUpdateResponseDTO variant = variantMap.get(item.getVariantId());
            if (variant == null) {
                throw new NotFoundException("Variant not found: " + item.getVariantId());
            }
            item.setPrice(variant.getPrice());
            String attribute = variant.getAttributes()
                    .stream()
                    .map(a -> a.getName() + ": " + a.getValue())
                    .collect(Collectors.joining(" / "));
            item.setAttribute(attribute);
            totalPrice += item.getQuantity() * variant.getPrice();
        }
        Order order = Order
                .builder()
                .totalPrice(totalPrice)
                .userId("123")
                .totalItems(totalItems)
                .status(OrderStatus.PENDING)
                .build();
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
        }
        List<OrderItem> createOrderItems = orderItemService.createList(orderItems);
        order.setOrderItems(createOrderItems);
        return create(order);
    }
}
