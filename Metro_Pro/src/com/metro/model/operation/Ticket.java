package com.metro.model.operation;

import com.metro.enums.TicketStatus;
import com.metro.enums.TicketType;
import com.metro.model.people.Customer;
import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;        // Mã vé (VD: T-20231025-001)
    private Customer owner;         // Người sở hữu vé
    private TicketType type;        // Loại vé (Lượt, Tháng...)
    private TicketStatus status;    // Trạng thái (ACTIVE, USED...)
    private double price;           // Giá tiền đã thanh toán
    private int maxRides;
    private int ridesUsed;
    
    
    private LocalDateTime issueDate;    // Ngày phát hành
    private LocalDateTime expiryDate;   // Ngày hết hạn
    
    // Lưu vết hành trình (để tính tiền hoặc kiểm soát ra vào)
    private String entryStationId;
    private String exitStationId;

    // Constructor
    public Ticket(String ticketId, Customer owner, TicketType type, double price) {
        this.ticketId = ticketId;
        this.owner = owner;
        this.type = type;
        this.price = price;
        this.status = TicketStatus.ACTIVE;
        this.issueDate = LocalDateTime.now();
        this.maxRides = maxRides;
        this.ridesUsed = 0;
        
        // Logic tính ngày hết hạn dựa trên loại vé
        calculateExpiryDate();
    }

    // --- LOGIC NGHIỆP VỤ ---

    /**
     * Tự động tính ngày hết hạn dựa trên loại vé.
     */
    private void calculateExpiryDate() {
        switch (this.type) {
            case SINGLERIDE: // Vé lượt: Hết hạn trong ngày
                this.expiryDate = LocalDateTime.now().withHour(23).withMinute(59);
                break;
            case DAYPASS: // Vé ngày: 24h
                this.expiryDate = LocalDateTime.now().plusDays(1);
                break;
            case MONTHLYPASS: // Vé tháng: 30 ngày
            case STUDENTPASS:
            case SENIORPASS:
                this.expiryDate = LocalDateTime.now().plusDays(30);
                break;
            default:
                this.expiryDate = LocalDateTime.now().plusHours(4); // Mặc định
        }
    }

    /**
     * Kiểm tra vé có hợp lệ để qua cổng không.
     */
    public boolean isValid() {
        if (this.status != TicketStatus.ACTIVE) {
            return false; // Vé đã dùng, bị khóa hoặc hủy
        }
        if (LocalDateTime.now().isAfter(expiryDate)) {
            this.status = TicketStatus.EXPIRED;
            return false; // Vé hết hạn
        }
        return true;
    }

    /**
     * Đánh dấu vé đã được sử dụng (khi qua cổng soát vé).
     * Chỉ áp dụng cho vé lượt.
     */
    public void markAsUsed(String stationId) {
        // Nếu là vé lượt, sau khi quẹt ra thì tính là USED
        if (this.type == TicketType.SINGLERIDE) {
            this.status = TicketStatus.USED;
        }
        // Vé tháng/ngày thì vẫn giữ ACTIVE cho đến khi hết hạn
        this.exitStationId = stationId;
    }

    // --- GETTERS & SETTERS ---

    public String getTicketId() { return ticketId; }
    public Customer getOwner() { return owner; }
    public TicketType getType() { return type; }
    public double getPrice() { return price; }
    
    public TicketStatus getStatus() { return status; }
    public void setStatus(TicketStatus status) { this.status = status; }

    public LocalDateTime getIssueDate() { return issueDate; }
    public LocalDateTime getExpiryDate() { return expiryDate; }

    public String getEntryStationId() { return entryStationId; }
    public void setEntryStationId(String entryStationId) { this.entryStationId = entryStationId; }

    public String getExitStationId() { return exitStationId; }
    public void setExitStationId(String exitStationId) { this.exitStationId = exitStationId; }

    @Override
    public String toString() {
        return "Vé [" + type + "] - Giá: " + price + " - Trạng thái: " + status;
    }
}