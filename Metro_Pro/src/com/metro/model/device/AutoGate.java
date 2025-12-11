package com.metro.model.device;

import com.metro.model.operation.Ticket;

public class AutoGate extends Device {
    private boolean isOpen;

    public AutoGate(String serialNumber) {
        super(serialNumber);
        this.isOpen = false;
    }

    public boolean scanTicket(Ticket ticket) {
        if (this.isOnline && ticket.isValid()) {
            openGate();
            return true;
        }
        return false;
    }

    private void openGate() {
        this.isOpen = true;
        System.out.println("Gate " + serialNumber + " opened.");
        // Tự động đóng sau 5s (logic giả lập)
    }

    @Override
    public void restart() {
        System.out.println("Restarting AutoGate...");
        this.isOnline = true;
        this.isOpen = false;
    }
}