package com.attendance.attendance_system.controller;

import com.attendance.attendance_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

@RestController
@RequestMapping("/attendance")

public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/punch")
    public ResponseEntity<String> punchAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        attendanceService.punchAttendance(attendanceDTO.getUserId(), attendanceDTO.getDateTime(), attendanceDTO.getPunchType());
        return ResponseEntity.ok("Attendance Punch Recorded");
    }

    @GetMapping("/report/{userId}/{month}")
    public ResponseEntity<AttendanceReport> getAttendanceReport(@PathVariable Long userId, @PathVariable String month) {
        YearMonth yearMonth = YearMonth.parse(month);
        AttendanceReport report = attendanceService.getAttendanceReport(userId, yearMonth);
        return ResponseEntity.ok(report);
    }
}

