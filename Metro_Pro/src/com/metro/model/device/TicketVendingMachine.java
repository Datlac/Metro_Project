package com.metro.model.device;

public class TicketVendingMachine extends Device {
    private double cashBalance;

    public TicketVendingMachine(String serialNumber) {
        super(serialNumber);
        this.cashBalance = 0.0;
    }

    public void printTicket() {
        System.out.println("Printing ticket...");
    }

    @Override
    public void restart() {
        System.out.println("Restarting TVM...");
    }
}