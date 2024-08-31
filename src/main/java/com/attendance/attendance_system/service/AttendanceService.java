package com.attendance.attendance_system.service;

import com.attendance.attendance_system.controller.AttendanceReport;
import com.attendance.attendance_system.entity.Attendance;
import com.attendance.attendance_system.repository.AttendanceRepository;
import com.attendance.attendance_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    public void punchAttendance(Long userId, LocalDateTime dateTime, Attendance.PunchType punchType) {
        // Check if user exists
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User does not exist.");
        }

        // Check time is within working hours
        LocalTime punchTime = dateTime.toLocalTime();
        if (punchTime.isBefore(LocalTime.of(7, 0)) || punchTime.isAfter(LocalTime.of(22, 0))) {
            throw new IllegalArgumentException("Punch time is outside working hours.");
        }

        // Fetch the user's previous attendance records
        List<Attendance> attendanceList = attendanceRepository.findByUserIdAndDate(userId, LocalDate.from(dateTime.toLocalDate().atStartOfDay()));

        // Validate the punch order logic here (IN first, then OUT, etc.)
        // Add your validation logic

        // Save the punch record
        Attendance attendance = new Attendance(userId, dateTime, punchType);
        attendanceRepository.save(attendance);
    }
    public AttendanceReport getAttendanceReport(Long userId, YearMonth yearMonth) {
        // Define the start and end of the month
        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();

        // Fetch attendance records for the month
        List<Attendance> records = attendanceRepository.findByUserIdAndDate(userId, startDate);

        // Implement report generation logic here
        // This will include calculating total hours, breaks, etc.
        return new AttendanceReport();
    }

}
