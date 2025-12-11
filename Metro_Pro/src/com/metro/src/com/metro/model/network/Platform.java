package com.metro.model.network;

import com.metro.model.train.Train;

public class Platform {
    private String platformId;      // Mã sân ga (VD: S01-P1)
    private String description;     // Mô tả (VD: Hướng Suối Tiên)
    private boolean isOccupied;     // Có tàu đang đậu không?
    private Train currentTrain;     // Tàu đang đậu (nếu có)

    public Platform(String platformId, String description) {
        this.platformId = platformId;
        this.description = description;
        this.isOccupied = false;
        this.currentTrain = null;
    }

    // --- LOGIC VẬN HÀNH ---

    /**
     * Tàu vào bến.
     * @return true nếu vào bến thành công, false nếu bến đang bận.
     */
    public boolean dockTrain(Train train) {
        if (isOccupied) {
            System.out.println("Sân ga " + platformId + " đang có tàu!");
            return false;
        }
        this.currentTrain = train;
        this.isOccupied = true;
        System.out.println("Tàu " + train.getTrainCode() + " đã cập bến " + platformId);
        return true;
    }

    /**
     * Tàu rời bến.
     */
    public void undockTrain() {
        if (this.currentTrain != null) {
            System.out.println("Tàu " + this.currentTrain.getTrainCode() + " đã rời bến " + platformId);
            this.currentTrain = null;
            this.isOccupied = false;
        }
    }

    // --- GETTERS & SETTERS ---
    
    public String getPlatformId() { return platformId; }
    public boolean isOccupied() { return isOccupied; }
    
    @Override
    public String toString() {
        return "Sân ga " + platformId + " (" + description + ")";
    }
}