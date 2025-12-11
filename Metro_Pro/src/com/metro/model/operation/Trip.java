package com.metro.model.operation;

import com.metro.enums.TripStatus;
import com.metro.model.train.Train;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trip {

    private String tripId;              // Mã chuyến đi (VD: TRIP-001)
    private Train train;                // Đoàn tàu thực hiện chuyến đi này
    private LocalDateTime departureTime;// Giờ khởi hành dự kiến
    private LocalDateTime arrivalTime;  // Giờ đến dự kiến
    private TripStatus status;          // Trạng thái (Đang đi, Đã đến, Hoãn...)
    private String routeDescription;    // Mô tả lộ trình (VD: Bến Thành -> Suối Tiên)

    // Constructor
    public Trip(String tripId, Train train, LocalDateTime departureTime, String routeDescription) {
        this.tripId = tripId;
        this.train = train;
        this.departureTime = departureTime;
        this.routeDescription = routeDescription;
        this.status = TripStatus.SCHEDULED; // Mặc định là Lên lịch
    }

    // --- LOGIC NGHIỆP VỤ ---

    public void startTrip() {
        if (this.status == TripStatus.SCHEDULED || this.status == TripStatus.DELAYED) {
            this.status = TripStatus.ON_GOING;
            System.out.println("Chuyến đi " + tripId + " bắt đầu khởi hành.");
        }
    }

    public void completeTrip() {
        this.status = TripStatus.COMPLETED;
        this.arrivalTime = LocalDateTime.now(); // Ghi nhận giờ đến thực tế
        System.out.println("Chuyến đi " + tripId + " đã hoàn thành lúc " + 
                arrivalTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }

    public void cancelTrip() {
        this.status = TripStatus.CANCELLED;
        System.out.println("Cảnh báo: Chuyến đi " + tripId + " đã bị hủy.");
    }

    // --- GETTERS & SETTERS ---

    public String getTripId() { return tripId; }
    
    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    
    public TripStatus getStatus() { return status; }
    public void setStatus(TripStatus status) { this.status = status; }

    public String getRouteDescription() { return routeDescription; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm dd/MM");
        return tripId + " | " + routeDescription + " | KH: " + departureTime.format(fmt) + " | " + status;
    }
}