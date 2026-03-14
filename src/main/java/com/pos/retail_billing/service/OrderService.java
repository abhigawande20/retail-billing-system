package com.pos.retail_billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.retail_billing.dto.DashboardStats;
import com.pos.retail_billing.model.CartItem;
import com.pos.retail_billing.model.Order;
import com.pos.retail_billing.model.Product;
import com.pos.retail_billing.repository.OrderRepository;
import com.pos.retail_billing.repository.ProductRepository;
import com.pos.retail_billing.utils.PdfGenerator;

@Service
public class OrderService {

    @Autowired
private ProductRepository productRepository;

    @Autowired
    private OrderRepository repository;

 public Order createOrder(Order order) {

    double subtotal = 0;

    for (CartItem item : order.getItems()) {

        Product product = productRepository
                .findById(item.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 🚫 STOCK CHECK
        if (product.getStock() < item.getQuantity()) {
            throw new RuntimeException(
                    "Not enough stock for product: " + product.getName());
        }

        subtotal += item.getPrice() * item.getQuantity();

        int newStock = product.getStock() - item.getQuantity();
        product.setStock(newStock);

        productRepository.save(product);
    }

    double tax = subtotal * 0.05;
    double total = subtotal + tax;

    order.setSubtotal(subtotal);
    order.setTax(tax);
    order.setTotal(total);

    Order savedOrder = repository.save(order);

    PdfGenerator.generateInvoice(savedOrder);

    return savedOrder;
}

    public List<Order> getOrders() {
        return repository.findAll();
    }


    public DashboardStats getDashboardStats() {

    List<Order> orders = repository.findAll();

    double revenue = 0;
    int itemsSold = 0;

    for (Order order : orders) {

        revenue += order.getTotal();

        for (CartItem item : order.getItems()) {
            itemsSold += item.getQuantity();
        }
    }

    DashboardStats stats = new DashboardStats();

    stats.setTotalRevenue(revenue);
    stats.setTotalOrders(orders.size());
    stats.setTotalItemsSold(itemsSold);

    return stats;
}

}