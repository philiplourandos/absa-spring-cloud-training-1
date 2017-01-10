package com.absa.training.olsen.persistence.repository;

import com.absa.training.olsen.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
