package com.attendance.attendance_system.repository;

import com.attendance.attendance_system.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

        // Query by extracting the date part of dateTime field
        @Query("SELECT a FROM Attendance a WHERE a.userId = :userId AND FUNCTION('DATE', a.dateTime) = :date")
        List<Attendance> findByUserIdAndDate(@Param("userId") Long userId, @Param("date") LocalDate date);



    }

