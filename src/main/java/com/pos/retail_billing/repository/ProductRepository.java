package com.pos.retail_billing.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pos.retail_billing.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByNameContainingIgnoreCase(String name);

}