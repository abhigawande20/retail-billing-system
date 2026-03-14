package com.pos.retail_billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pos.retail_billing.model.Product;
import com.pos.retail_billing.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
    }

    @GetMapping("/search")
public List<Product> searchProducts(@RequestParam String name) {
    return service.searchProducts(name);
}
}