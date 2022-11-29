package com.tool.smarthrbackend.controller;


import com.tool.smarthrbackend.model.attendance.Attendance;
import com.tool.smarthrbackend.pojo.attendance.AttendanceRequest;
import com.tool.smarthrbackend.pojo.attendance.AttendanceResponse;
import com.tool.smarthrbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smarthr/attendance")


public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;


    @PostMapping (path = "/getAttendanceData")
    public AttendanceResponse getAttendanceData(@RequestBody AttendanceRequest attendanceRequest){
        AttendanceResponse attendanceResponse=null;
        attendanceResponse=attendanceService.getAttendanceData(attendanceRequest);
        return attendanceResponse;
    }

    @PostMapping (path = "/getAttendanceDatalist")
    public List<Attendance> getAttendanceDataList(@RequestBody AttendanceRequest attendanceRequest){
        List<Attendance> attendanceList;
        attendanceList=attendanceService.getAttendanceDatalist(attendanceRequest);
        return attendanceList;
    }
}
