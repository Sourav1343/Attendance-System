package com.attendance.attendance_system.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
@Getter
@Setter
public class AttendanceReport {
        private Map<LocalDate, DailyReport> dailyReports;
        private WeeklyReport weeklySummary;
        private MonthlyReport monthlySummary;

        // Constructor, Getters and Setters
    }

