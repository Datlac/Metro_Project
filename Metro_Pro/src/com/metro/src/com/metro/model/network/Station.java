package com.metro.model.network;

import com.metro.enums.StationStatus;
import java.util.ArrayList;
import java.util.List;

public class Station {
    
    private String stationId;       // Mã trạm (VD: S01)
    private String stationName;     // Tên trạm (VD: Bến Thành)
    private StationStatus status;   // Trạng thái (Mở, Đóng, Bảo trì)
    private List<Platform> platforms; // Danh sách các sân ga trong trạm này

    public Station(String stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.status = StationStatus.OPEN; // Mặc định mở cửa
        this.platforms = new ArrayList<>();
        
        // Mặc định tạo 2 sân ga (Chiều đi và Chiều về)
        this.platforms.add(new Platform(stationId + "-P1", "Hướng đi"));
        this.platforms.add(new Platform(stationId + "-P2", "Hướng về"));
    }

    // --- LOGIC NGHIỆP VỤ ---

    public void broadcastAnnouncement(String message) {
        if (status == StationStatus.OPEN) {
            System.out.println("[LOA PHÁT THANH - GA " + stationName.toUpperCase() + "]: " + message);
        } else {
            System.out.println("Ga " + stationName + " đang đóng cửa, không thể phát loa.");
        }
    }

    public void addPlatform(Platform platform) {
        this.platforms.add(platform);
    }

    // --- GETTERS & SETTERS ---

    public String getStationId() { return stationId; }
    public void setStationId(String stationId) { this.stationId = stationId; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }

    public StationStatus getStatus() { return status; }
    public void setStatus(StationStatus status) { this.status = status; }

    public List<Platform> getPlatforms() { return platforms; }

    // Quan trọng cho GUI: ComboBox sẽ gọi hàm này để hiển thị tên
    @Override
    public String toString() {
        return stationName; 
    }
    
    // So sánh 2 trạm (để tìm đường đi)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Station station = (Station) obj;
        return stationId.equals(station.stationId);
    }
}