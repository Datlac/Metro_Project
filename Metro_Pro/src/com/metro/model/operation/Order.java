package com.metro.model.operation;

import com.metro.enums.OrderStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private LocalDate createdTime;
    private String customerId;
    private OrderStatus status;
    private List<Ticket> orderItems;

    public Order(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.createdTime = LocalDate.now();
        this.status = OrderStatus.PENDING;
        this.orderItems = new ArrayList<>();
    }

    public void addItem(Ticket ticket) {
        orderItems.add(ticket);
    }

    public void calculateTotal() {
        double total = orderItems.stream().mapToDouble(Ticket::getPrice).sum();
        System.out.println("Total Amount: " + total);
    }
}