package com.absa.training.olsen.web.resource;

import com.absa.training.olsen.persistence.model.Customer;
import com.absa.training.olsen.services.CustomerService;
import com.absa.training.olsen.web.model.CustomerRegisterRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> list() {
        return this.customerService.listAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable Long id) {
        return this.customerService.getById(id);
    }

//    @PostMapping("{id}/addresses/shipping")
//    public void updateShippingAddress(@PathVariable Long id, @RequestBody UpdateCustomerShippingAddressCommand command) {
//
//    }

    @PostMapping("register")
    public Customer register(@Valid @RequestBody CustomerRegisterRequest command) {
        return this.customerService.register(command);
    }



}
