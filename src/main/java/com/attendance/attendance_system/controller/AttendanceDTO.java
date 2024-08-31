package com.attendance.attendance_system.controller;

import com.attendance.attendance_system.entity.Attendance;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AttendanceDTO {
    private Long userId;
    private LocalDateTime dateTime;
    private Attendance.PunchType punchType;

}

