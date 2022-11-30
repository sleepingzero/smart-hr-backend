package com.tool.smarthrbackend.controller;


import com.tool.smarthrbackend.model.attendance.Attendance;
import com.tool.smarthrbackend.model.common.PaginationModel;
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

    @PostMapping (path = "/getAttendanceDatalist")
    public List<AttendanceResponse> getAttendanceDataList(@RequestBody AttendanceRequest attendanceRequest){
        List<Attendance> attendanceList;
        List<AttendanceResponse> attendanceResponseList;
        attendanceResponseList=attendanceService.getAttendanceDatalist(attendanceRequest);
        return attendanceResponseList;
    }
}
