package com.rayyanhunerkar;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
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
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return null;
        }
        return "Customer Not found";
    }

    @GetMapping("{id}")
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id);
    }

    @PatchMapping("{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody CustomerRequest request) {
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
            Integer age
    ) {

    }
}
