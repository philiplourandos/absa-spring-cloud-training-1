package com.absa.training.olsen.services;

import com.absa.training.olsen.persistence.model.Cart;
import com.absa.training.olsen.persistence.model.CartItem;
import com.absa.training.olsen.persistence.model.Customer;
import com.absa.training.olsen.persistence.repository.CartRepository;
import com.absa.training.olsen.persistence.repository.CustomerRepository;
import com.absa.training.olsen.web.commands.AddProductToCartCommand;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    public CartService(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    public Cart getOrCreateCart(Long customerId) {
        Customer customer = this.customerRepository.findOne(customerId);
        if (customer == null) {
            throw new EntityNotFoundException(String.format("Customer with id '%s' not found", customerId));
        }

        Cart cart = this.cartRepository.findByCustomer(customer);

        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer);
            cart = this.cartRepository.save(cart);
        }

        return cart;
    }

    public Boolean addProductToCart(Long customerId, AddProductToCartCommand command) {
        Cart cart = getOrCreateCart(customerId);

        CartItem newCartItem = new CartItem();
        newCartItem.setParent(cart);
        newCartItem.setProductId(command.getProductId());
        newCartItem.setQuantity(command.getQuantity());

        cart.getItems().add(newCartItem);

        this.cartRepository.save(cart);

        return true;
    }

}
