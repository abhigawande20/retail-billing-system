package com.pos.retail_billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pos.retail_billing.dto.DashboardStats;
import com.pos.retail_billing.service.OrderService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private OrderService service;

    @GetMapping("/stats")
    public DashboardStats getStats() {
        return service.getDashboardStats();
    }
}