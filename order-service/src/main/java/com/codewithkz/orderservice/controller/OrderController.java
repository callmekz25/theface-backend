package com.codewithkz.orderservice.controller;

import com.codewithkz.commonlibrary.controller.BaseController;
import com.codewithkz.orderservice.dto.order.OrderCreateUpdateRequestDTO;
import com.codewithkz.orderservice.dto.order.OrderCreateUpdateResponseDTO;
import com.codewithkz.orderservice.model.Order;
import com.codewithkz.orderservice.mapper.OrderMapper;
import com.codewithkz.orderservice.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController extends BaseController<Order, OrderCreateUpdateRequestDTO, OrderCreateUpdateResponseDTO, String, String> {

    private final OrderServiceImpl service;
    private final OrderMapper mapper;

    public OrderController(OrderServiceImpl service, OrderMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<OrderCreateUpdateResponseDTO> create(@RequestBody OrderCreateUpdateRequestDTO request) {
        Order created = service.create(request);
        OrderCreateUpdateResponseDTO responseDTO = mapper.toDTO(created);
        return ResponseEntity.ok(responseDTO);
    }


}
