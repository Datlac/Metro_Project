package com.metro.model.device;

public abstract class Device {
    protected String serialNumber;
    protected boolean isOnline;

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
        this.isOnline = true;
    }

    public boolean checkConnectivity() {
        return isOnline;
    }
    
    // Abstract method cho UML Source 188 (Operation chưa đặt tên rõ ràng, giả sử là restart)
    public abstract void restart();
}