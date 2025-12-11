package com.metro.model.network;

import com.metro.enums.LineStatus; // Bạn cần tạo Enum này nếu chưa có
import java.util.ArrayList;
import java.util.List;

public class Line {
    
    private String lineCode;        // Mã tuyến (VD: L01)
    private String name;            // Tên tuyến (VD: Bến Thành - Suối Tiên)
    private LineStatus status;      // Trạng thái tuyến
    private List<Station> orderedStations; // Danh sách trạm theo thứ tự

    public Line(String lineCode, String name) {
        this.lineCode = lineCode;
        this.name = name;
        // Giả sử có enum LineStatus.OPERATING
        // Nếu chưa có, bạn có thể dùng String hoặc tạo thêm enum
        this.status = null; 
        this.orderedStations = new ArrayList<>();
    }

    // --- LOGIC QUẢN LÝ TUYẾN ---

    /**
     * Thêm trạm vào cuối tuyến.
     */
    public void addStation(Station station) {
        if (!orderedStations.contains(station)) {
            orderedStations.add(station);
        }
    }

    /**
     * Chèn trạm vào vị trí cụ thể (VD: Xây thêm trạm mới giữa 2 trạm cũ).
     */
    public void insertStation(int index, Station station) {
        if (index >= 0 && index <= orderedStations.size()) {
            orderedStations.add(index, station);
        }
    }

    public void removeStation(Station station) {
        orderedStations.remove(station);
    }

    /**
     * Lấy danh sách trạm để vẽ bản đồ hoặc tính lộ trình.
     */
    public List<Station> getStations() {
        return orderedStations;
    }

    // --- GETTERS & SETTERS ---

    public String getLineCode() { return lineCode; }
    public String getName() { return name; }
    
    // Cần tạo enum LineStatus trong com.metro.enums nếu muốn dùng
    // public LineStatus getStatus() { return status; }
    // public void setStatus(LineStatus status) { this.status = status; }

    @Override
    public String toString() {
        return name + " (" + orderedStations.size() + " trạm)";
    }
}