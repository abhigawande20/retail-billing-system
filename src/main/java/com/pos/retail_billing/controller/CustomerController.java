package com.pos.retail_billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pos.retail_billing.model.Customer;
import com.pos.retail_billing.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(id);
    }
}