package com.tool.smarthrbackend.controller;


import com.tool.smarthrbackend.service.AttendanceService;
import org.hibernate.boot.model.source.spi.PluralAttributeElementNature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smarthr/attendance")


public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;
}
