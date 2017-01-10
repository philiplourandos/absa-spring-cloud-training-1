package com.absa.training.olsen.services;

import com.absa.training.olsen.web.commands.CreateOrderCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("order-service")
public interface OrderService {

    @PostMapping("orders")
    Long createOrder(CreateOrderCommand command);

}
