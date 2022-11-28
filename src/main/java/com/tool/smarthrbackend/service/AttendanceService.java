package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.attendance.Attendance;
import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import com.tool.smarthrbackend.repository.jpa.attendance.AttendanceRepository;
import com.tool.smarthrbackend.repository.jpa.employee.EmployeeRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.AttendanceShiftsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class AttendanceService {

@Autowired
AttendanceRepository attendancerepository;

@Autowired
AttendanceShiftsRepository attendanceShiftsRepository;

@Autowired
    EmployeeRepository employeeRepository;
//
//    public void submitAttendance(Long empId) {
//        Attendance atd=null ;
//        LocalDate date1= LocalDate.now();
//        atd=attendancerepository.findByEmployeeIdAndDate(4L,date1).get();
//        System.out.println("fgggggggggggggggfjffg"+attendancerepository.existsByEmployeeIdAndDate(5L,date1));
//        System.out.println(atd);
//        Attendance attendance = new Attendance();
//        Employee employee;
//        AttendanceShifts attendanceShifts;
//        employee=employeeRepository.findById(empId).get();
//        attendance.setEmployee(employee);
//        attendanceShifts=employee.getAttendanceShifts();
//        attendance.setAttendanceShifts(attendanceShifts);
//        java.util.Date today = new java.util.Date();
//
//      attendance.setDate(LocalDate.now());
//        //        LocalDate date= LocalDate.now();
////        java.sql.Date mySqlDate = java.sql.Date.valueOf( date );
////        attendance.setCurrentDate(mySqlDate);
////        System.out.println(date);
//        attendancerepository.save(attendance);
//    }
}
