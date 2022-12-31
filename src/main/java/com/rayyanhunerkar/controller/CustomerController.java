package com.rayyanhunerkar.controller;

import com.rayyanhunerkar.model.Customer;
import com.rayyanhunerkar.model.Theatre;
import com.rayyanhunerkar.repository.CustomerRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody @NotNull CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);
        customer.setTheatres(request.theatres);
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        customerRepository.findById(id).map(
                customer -> {
                    customerRepository.deleteById(id);
                    return null;
                }
        );
    }

    @GetMapping("{id}")
    public Optional<Customer> getCustomerById(@PathVariable UUID id) {
        return customerRepository.findById(id);
    }

    @PatchMapping("{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody CustomerRequest request) {
        customerRepository.findById(id).ifPresent(
                customer -> {
                    customer.setAge(request.age);
                    customer.setName(request.name);
                    customer.setEmail(request.email);
                    customerRepository.save(customer);
                }
        );
    }

    record CustomerRequest(
            String name,
            String email,
            Integer age,
            Set<Theatre> theatres
    ) {

    }
}
