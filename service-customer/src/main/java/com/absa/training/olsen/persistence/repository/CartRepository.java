package com.absa.training.olsen.persistence.repository;

import com.absa.training.olsen.persistence.model.Cart;
import com.absa.training.olsen.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByCustomer(Customer customer);

    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem i WHERE i.id = :cartItemId")
    void deleteCartItem(@Param(value = "cartItemId") Long cartItemId);

}
