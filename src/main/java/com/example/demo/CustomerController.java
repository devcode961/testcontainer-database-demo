package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping(value = "/api/customers", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody CustomerDTO customer) {
        log.info("Creating customer: {}", customer);
        var customerEntity = Customer.builder()
                .name(customer.getName())
                .build();
        return customerRepository.save(customerEntity);
    }

}
