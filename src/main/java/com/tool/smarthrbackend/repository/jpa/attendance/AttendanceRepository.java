package com.tool.smarthrbackend.repository.jpa.attendance;

import com.tool.smarthrbackend.model.attendance.Attendance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance , Long> {

  Optional<Attendance> findByEmployeeIdAndDate(Long employeeId,LocalDate date);

Page<Attendance> findByEmployeeIdInAndDateBetweenOrderByDateDesc(List<Long> employeeIdList , LocalDate startDate , LocalDate endDate, Pageable pageable);


  boolean existsByEmployeeIdAndDate(Long employeeId,LocalDate date);
//
//  List<Attendance>
}
