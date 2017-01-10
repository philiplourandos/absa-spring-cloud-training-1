package com.absa.training.olsen.services;

import com.absa.training.olsen.persistence.model.Order;
import com.absa.training.olsen.persistence.model.OrderStatus;
import com.absa.training.olsen.persistence.repository.OrderRepository;
import com.absa.training.olsen.web.commands.CreateOrderCommand;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(CreateOrderCommand command) {
        Order newOrder = new Order();
        newOrder.setCustomerName(command.getCustomerFirstName() + " " + command.getCustomerLastName());
        newOrder.setOrderDateTime(LocalDateTime.now());
        newOrder.setOrderStatus(OrderStatus.NEW);
        newOrder.setOrderTotal(BigDecimal.ONE);

        return this.orderRepository.save(newOrder);
    }

    public List<Order> listAll() {
        return this.orderRepository.findAll();
    }
}
