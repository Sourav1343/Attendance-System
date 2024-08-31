package com.attendance.attendance_system.controller;

import lombok.Getter;
import lombok.Setter;
import java.time.Duration;

@Getter
@Setter
public class WeeklyReport {
    private int weekNumber;
    private Duration totalWorkedHours;
    private Duration consideredHours;

    // Constructor, Getters, and Setters
}
