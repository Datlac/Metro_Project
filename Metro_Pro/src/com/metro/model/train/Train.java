package com.metro.model.train;

import com.metro.enums.TrainStatus;
import java.util.ArrayList;
import java.util.List;

public class Train {

    private String trainCode;           // Mã đoàn tàu (VD: VN-METRO-01)
    private TrainStatus status;         // Trạng thái (Đang chạy, Bảo trì...)
    private double currentSpeed;        // Tốc độ hiện tại (km/h)
    
    // Một tàu bao gồm nhiều đầu máy và nhiều toa xe
    private List<Locomotive> locomotives;
    private List<Carriage> carriages;

    // Constructor
    public Train(String trainCode) {
        this.trainCode = trainCode;
        this.status = TrainStatus.IDLE; // Mặc định là Nhàn rỗi
        this.currentSpeed = 0.0;
        this.locomotives = new ArrayList<>();
        this.carriages = new ArrayList<>();
    }

    // --- CÁC PHƯƠNG THỨC QUẢN LÝ THÀNH PHẦN ---

    public void addLocomotive(Locomotive loc) {
        if (loc != null) {
            this.locomotives.add(loc);
        }
    }

    public void addCarriage(Carriage car) {
        if (car != null) {
            this.carriages.add(car);
        }
    }

    /**
     * Tính toán động tổng sức chứa hành khách của cả đoàn tàu.
     * Bằng tổng sức chứa của tất cả các toa cộng lại.
     */
    public int calculateTotalCapacity() {
        int total = 0;
        for (Carriage c : carriages) {
            total += c.getTotalCapacity();
        }
        return total;
    }

    /**
     * Tính tổng trọng lượng của đoàn tàu (Đầu máy + Toa xe).
     * Dùng để kiểm tra an toàn đường ray.
     */
    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (Locomotive l : locomotives) totalWeight += l.getWeight();
        for (Carriage c : carriages) totalWeight += c.getWeight();
        return totalWeight;
    }

    // --- GETTERS & SETTERS ---

    public String getTrainCode() { return trainCode; }
    public void setTrainCode(String trainCode) { this.trainCode = trainCode; }

    public TrainStatus getStatus() { return status; }
    public void setStatus(TrainStatus status) { this.status = status; }

    public double getCurrentSpeed() { return currentSpeed; }
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }

    public List<Locomotive> getLocomotives() { return locomotives; }
    public List<Carriage> getCarriages() { return carriages; }

    // Override toString để hiển thị đẹp trên GUI (ComboBox/Table)
    @Override
    public String toString() {
        return trainCode + " (" + getStatus() + ")";
    }
}