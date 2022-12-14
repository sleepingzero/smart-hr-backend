package com.tool.smarthrbackend.controller;


import com.tool.smarthrbackend.model.attendance.Attendance;
import com.tool.smarthrbackend.pojo.attendance.AttendanceRequest;
import com.tool.smarthrbackend.pojo.attendance.AttendanceData;
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

    @PostMapping (path = "/getAttendanceDatalist")
    public AttendanceResponse getAttendanceDataList(@RequestBody AttendanceRequest attendanceRequest){
          AttendanceResponse attendanceResponse=null;
        List<AttendanceData> attendanceDataList = null;
        attendanceResponse =attendanceService.getAttendanceDatalist(attendanceRequest);
        return attendanceResponse;
    }
}
