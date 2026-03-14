package com.pos.retail_billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.retail_billing.model.Customer;
import com.pos.retail_billing.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }
}
