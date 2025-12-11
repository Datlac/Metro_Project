package com.metro.model.management;

import java.time.LocalTime;

public class Shift {
    private String shiftCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private String notes;

    public Shift(String shiftCode, LocalTime start, LocalTime end) {
        this.shiftCode = shiftCode;
        this.startTime = start;
        this.endTime = end;
    }
    // Getters Setters
}