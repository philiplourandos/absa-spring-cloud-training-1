package com.absa.training.olsen.services;

import com.absa.training.olsen.persistence.model.Cart;
import com.absa.training.olsen.persistence.model.CartItem;
import com.absa.training.olsen.persistence.model.Customer;
import com.absa.training.olsen.persistence.repository.CartRepository;
import com.absa.training.olsen.persistence.repository.CustomerRepository;
import com.absa.training.olsen.web.commands.AddProductToCartCommand;
import com.absa.training.olsen.web.commands.CreateOrderCommand;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    public CartService(CartRepository cartRepository, CustomerRepository customerRepository, OrderService orderService) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.orderService = orderService;
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

    public void deleteProductFromCart(Long customerId, Long productId) {
        Cart cart = getOrCreateCart(customerId);

        Long itemId = null;

        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(productId)) {
                itemId = item.getId();
                break;
            }
        }

        if (itemId != null) {
            cartRepository.deleteCartItem(itemId);
        }

        this.cartRepository.save(cart);

    }

    public Long checkout(Long customerId) {
        Cart cart = getOrCreateCart(customerId);

        if (cart.getItems().size() > 0) {
            Customer customer = customerRepository.getOne(customerId);
            Long orderId = orderService.createOrder(new CreateOrderCommand(customer.getFirstName(), customer.getLastName(), customer.getEmailAddress(), new ArrayList<Long>()));
            return orderId;
        } else {
            throw new IllegalArgumentException("Cart is empty, cannot continue with checkout");
        }


    }
}
