package com.tool.smarthrbackend.repository.jpa.attendance;

import com.tool.smarthrbackend.model.attendance.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance , Long> {

  Optional<Attendance> findByEmployeeIdAndDate(Long employeeId,LocalDate date);

List<Attendance> findByEmployeeIdAndDateBetween( Long employeeId , LocalDate startDate , LocalDate endDate);


  boolean existsByEmployeeIdAndDate(Long employeeId,LocalDate date);
//
//  List<Attendance>
}
