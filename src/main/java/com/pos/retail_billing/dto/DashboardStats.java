package com.pos.retail_billing.dto;

public class DashboardStats {

    private double totalRevenue;
    private long totalOrders;
    private int totalItemsSold;

    public DashboardStats() {}

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getTotalItemsSold() {
        return totalItemsSold;
    }

    public void setTotalItemsSold(int totalItemsSold) {
        this.totalItemsSold = totalItemsSold;
    }
}