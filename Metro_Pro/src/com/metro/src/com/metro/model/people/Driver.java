package com.metro.model.people;

import java.time.LocalDate;

public class Driver extends Staff {

    private String licenseNumber;       // Số bằng lái tàu
    private LocalDate licenseExpiryDate;// Ngày hết hạn bằng lái
    private float totalDrivingHours;    // Tổng số giờ lái tích lũy

    // Constructor
    public Driver(String id, String fullName, LocalDate dob, String phone, 
                  String employeeId, String department, 
                  String licenseNumber, LocalDate licenseExpiryDate) {
        // Gọi constructor của Staff (Lái tàu mặc định chức danh là "Train Driver")
        super(id, fullName, dob, phone, employeeId, department, "Train Driver");
        
        this.licenseNumber = licenseNumber;
        this.licenseExpiryDate = licenseExpiryDate;
        this.totalDrivingHours = 0.0f;
    }

    // --- CÁC PHƯƠNG THỨC LOGIC NGHIỆP VỤ ---

    /**
     * Cập nhật giờ lái sau mỗi chuyến đi.
     * @param hours Số giờ vừa lái
     */
    public void logDrivingHours(float hours) {
        if (hours > 0) {
            this.totalDrivingHours += hours;
        }
    }

    /**
     * Kiểm tra bằng lái còn hạn không.
     * @return true nếu còn hạn
     */
    public boolean isLicenseValid() {
        return licenseExpiryDate != null && licenseExpiryDate.isAfter(LocalDate.now());
    }

    @Override
    public String getRoleDescription() {
        return "Lái tàu chính (Bằng số: " + licenseNumber + ")";
    }

    // --- GETTERS & SETTERS ---

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public LocalDate getLicenseExpiryDate() { return licenseExpiryDate; }
    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) { this.licenseExpiryDate = licenseExpiryDate; }

    public float getTotalDrivingHours() { return totalDrivingHours; }
}