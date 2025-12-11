package com.metro.model.operation;

import com.metro.enums.PaymentMethod;

public class Transaction {
    private String transactionId;
    private double amount;
    private PaymentMethod paymentMethod;
    private boolean isSuccess;

    public Transaction(String transactionId, double amount, PaymentMethod method) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMethod = method;
        this.isSuccess = false; // Mặc định chưa thành công
    }

    public void processPayment() {
        // Logic kết nối cổng thanh toán
        this.isSuccess = true;
        generateInvoice();
    }

    public void generateInvoice() {
        if(isSuccess) System.out.println("Invoice generated for: " + transactionId);
    }
}