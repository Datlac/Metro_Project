package com.metro.model.train;

import com.metro.model.base.RollingStock;

public class Carriage extends RollingStock {

    private int seatCapacity;       // Số ghế ngồi
    private int standingCapacity;   // Số chỗ đứng tối đa
    private boolean hasWifi;        // Có Wifi không
    private boolean isAccessibilityCar; // Toa dành cho người khuyết tật

    // Constructor
    public Carriage(String serialNumber, double weight, int manufactureYear, 
                    int seatCapacity, int standingCapacity) {
        super(serialNumber, weight, manufactureYear);
        this.seatCapacity = seatCapacity;
        this.standingCapacity = standingCapacity;
        this.hasWifi = true; // Mặc định có Wifi
        this.isAccessibilityCar = false;
    }

    /**
     * Tính tổng sức chứa của toa này.
     */
    public int getTotalCapacity() {
        return seatCapacity + standingCapacity;
    }

    @Override
    public String getTechnicalSpecs() {
        return String.format("Toa xe [Ghế: %d, Đứng: %d, Tổng: %d khách]", 
                seatCapacity, standingCapacity, getTotalCapacity());
    }

    // --- GETTERS & SETTERS ---

    public int getSeatCapacity() { return seatCapacity; }
    public void setSeatCapacity(int seatCapacity) { this.seatCapacity = seatCapacity; }

    public int getStandingCapacity() { return standingCapacity; }
    public void setStandingCapacity(int standingCapacity) { this.standingCapacity = standingCapacity; }

    public boolean isHasWifi() { return hasWifi; }
    public void setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi; }

    public boolean isAccessibilityCar() { return isAccessibilityCar; }
    public void setAccessibilityCar(boolean accessibilityCar) { isAccessibilityCar = accessibilityCar; }
}