package com.absa.training.olsen.persistence.repository;

import com.absa.training.olsen.persistence.model.Cart;
import com.absa.training.olsen.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByCustomer(Customer customer);


}
