package com.tool.smarthrbackend.controller;


import com.tool.smarthrbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smarthr/attendance")


public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping(path = "/submitAttendance")
    public void submitAttendance(@RequestParam (value = "employee_id") Long empId){
//      attendanceService.submitAttendance(empId);
      return ;
    }
}
