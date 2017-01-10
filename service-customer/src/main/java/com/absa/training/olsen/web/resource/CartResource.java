package com.absa.training.olsen.web.resource;

import com.absa.training.olsen.persistence.model.Cart;
import com.absa.training.olsen.services.CartService;
import com.absa.training.olsen.web.commands.AddProductToCartCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartResource {

    private final CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("{customerId}")
    public Cart getCart(@PathVariable Long customerId) {
        return this.cartService.getOrCreateCart(customerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{customerId}/add")
    public void addToCart(@PathVariable Long customerId, @RequestBody AddProductToCartCommand command) {
        this.cartService.addProductToCart(customerId, command);
    }

    @DeleteMapping("{customerId}/delete/{productId}")
    public void removeFromCart(@PathVariable Long customerId, @PathVariable Long productId) {
        this.cartService.deleteProductFromCart(customerId, productId);
    }

    @GetMapping("{customerId}/checkout")
    public Long checkout(@PathVariable Long customerId) {
        return this.cartService.checkout(customerId);
    }



}
