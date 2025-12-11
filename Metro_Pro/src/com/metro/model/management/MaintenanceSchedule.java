package com.metro.model.management;

import com.metro.enums.PriorityLevel;
import java.time.LocalDate;

public class MaintenanceSchedule {
    private String scheduleId;
    private LocalDate plannedDate;
    private int estimatedDurationHours;
    private PriorityLevel priority;

    public MaintenanceSchedule(String id, LocalDate date, int duration, PriorityLevel priority) {
        this.scheduleId = id;
        this.plannedDate = date;
        this.estimatedDurationHours = duration;
        this.priority = priority;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(plannedDate);
    }

    public void reschedule(LocalDate newDate) {
        this.plannedDate = newDate;
    }
}