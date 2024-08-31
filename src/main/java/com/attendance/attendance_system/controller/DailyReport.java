package com.attendance.attendance_system.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
@Getter
@Setter
public class DailyReport {
    private LocalDate date;
    private Duration totalWorkedHours;
    private Duration breakTime;
    private Duration consideredHours;

    // Constructor, Getters, and Setters
}
