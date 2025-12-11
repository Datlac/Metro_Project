package com.metro.model.management;

import com.metro.enums.IncidentSeverity;
import com.metro.enums.IncidentStatus;
import java.time.LocalDate;

public class IncidentReport {
    private String reportId;
    private String title;
    private IncidentSeverity severity;
    private LocalDate reportedTime;
    private String affectedEquipmentId; // Liên kết với Device
    private String description;
    private IncidentStatus status;

    public IncidentReport(String reportId, String title, IncidentSeverity severity, String affectedEquipmentId) {
        this.reportId = reportId;
        this.title = title;
        this.severity = severity;
        this.affectedEquipmentId = affectedEquipmentId;
        this.reportedTime = LocalDate.now();
        this.status = IncidentStatus.NEW;
    }

    public void updateStatus(IncidentStatus newStatus, String note) {
        this.status = newStatus;
        System.out.println("Updated incident " + reportId + " to " + newStatus + ". Note: " + note);
    }
}