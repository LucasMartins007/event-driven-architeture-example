package com.github.awsservices.order.adapters.inbound.rest;

import com.github.awsservices.order.application.core.domain.OrderEvent;
import com.github.awsservices.order.application.core.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody OrderEvent orderEvent) {
        orderService.confirmOrder(orderEvent);

        return "Pedido confirmado";
    }

}
