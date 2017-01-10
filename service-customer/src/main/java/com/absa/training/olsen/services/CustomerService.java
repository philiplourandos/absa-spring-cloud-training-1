package com.absa.training.olsen.services;

import com.absa.training.olsen.persistence.model.Customer;
import com.absa.training.olsen.persistence.repository.CustomerRepository;
import com.absa.training.olsen.web.commands.RegisterCustomerCommand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public List<Customer> listAll() {
        return this.customerRepository.findAll();
    }

    public Customer register(RegisterCustomerCommand command) {
        Customer newCustomer = new Customer();
        newCustomer.setEmailAddress(command.getEmailAddress());
        newCustomer.setFirstName(command.getFirstName());
        newCustomer.setLastName(command.getLastName());

        return this.customerRepository.save(newCustomer);
    }

    public Customer getById(Long id) {
        return this.customerRepository.findOne(id);
    }
}
