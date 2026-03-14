package com.pos.retail_billing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pos.retail_billing.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    
}