package com.pos.retail_billing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pos.retail_billing.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}