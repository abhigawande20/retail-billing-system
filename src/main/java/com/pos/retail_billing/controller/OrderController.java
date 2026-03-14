package com.pos.retail_billing.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pos.retail_billing.model.Order;
import com.pos.retail_billing.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService service;

    // Create Order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    // Get All Orders
    @GetMapping
    public List<Order> getOrders() {
        return service.getOrders();
    }

    // Download Invoice
    @GetMapping("/invoice/{id}")
    public ResponseEntity<byte[]> downloadInvoice(@PathVariable String id) {

        try {

            String filePath = "invoices/invoice_" + id + ".pdf";
            File file = new File(filePath);

            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            byte[] data = Files.readAllBytes(file.toPath());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=" + file.getName())
                    .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                    .body(data);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}