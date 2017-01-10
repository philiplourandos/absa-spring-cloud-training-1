package com.absa.training.olsen.services;

import com.absa.training.olsen.web.commands.CreateOrderCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("order-service")
public interface OrderService {

    @RequestMapping(value = "orders", method = RequestMethod.POST)
    Long createOrder(CreateOrderCommand command);

}
