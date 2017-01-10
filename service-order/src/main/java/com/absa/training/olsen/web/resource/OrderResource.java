package com.absa.training.olsen.web.resource;

import com.absa.training.olsen.persistence.model.Order;
import com.absa.training.olsen.services.OrderService;
import com.absa.training.olsen.web.commands.CreateOrderCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Long createOrder(@RequestBody CreateOrderCommand command) {
        return this.orderService.create(command).getId();
    }

    @GetMapping
    public List<Order> list() {
        return this.orderService.listAll();
    }


}
