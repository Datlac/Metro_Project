package com.metro.model.base;

import java.time.Year;
import java.util.Objects;

/**
 * Lớp trừu tượng đại diện cho các thành phần cấu tạo nên đoàn tàu.
 * Bao gồm: Đầu máy (Locomotive) và Toa xe (Carriage).
 */
public abstract class RollingStock {
    
    protected String serialNumber;    // Số hiệu (Vd: LOC-001, CAR-A-05)
    protected double weight;          // Trọng lượng bản thân (Tấn)
    protected int manufactureYear;    // Năm sản xuất
    protected String manufacturer;    // Nhà sản xuất (Hitachi, Siemens...)

    // Constructor
    public RollingStock(String serialNumber, double weight, int manufactureYear) {
        if (serialNumber == null || serialNumber.isEmpty()) {
            throw new IllegalArgumentException("Số hiệu không được để trống");
        }
        this.serialNumber = serialNumber;
        this.weight = weight;
        this.manufactureYear = manufactureYear;
        this.manufacturer = "Unknown"; // Giá trị mặc định
    }

    // --- CÁC PHƯƠNG THỨC LOGIC CHUNG ---

    /**
     * Tính thời gian đã đưa vào sử dụng (Service Life).
     * @return số năm
     */
    public int getServiceYears() {
        int currentYear = Year.now().getValue();
        return currentYear - manufactureYear;
    }

    /**
     * Phương thức trừu tượng: Lớp con phải trả về thông số kỹ thuật đặc thù.
     * Vd: Đầu máy trả về công suất, Toa xe trả về số ghế.
     */
    public abstract String getTechnicalSpecs();

    // --- GETTERS & SETTERS ---

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public int getManufactureYear() { return manufactureYear; }
    public void setManufactureYear(int manufactureYear) { this.manufactureYear = manufactureYear; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    // --- OVERRIDE OBJECT METHODS ---
    // Giúp so sánh dựa trên SerialNumber
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollingStock that = (RollingStock) o;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "RollingStock{" +
                "SN='" + serialNumber + '\'' +
                ", Weight=" + weight + "t" +
                '}';
    }
}