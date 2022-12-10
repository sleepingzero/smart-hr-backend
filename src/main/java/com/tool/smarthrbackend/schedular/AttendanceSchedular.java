package com.tool.smarthrbackend.schedular;

import com.tool.smarthrbackend.repository.jpa.leave.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttendanceSchedular {
    @Autowired
    LeaveApplicationRepository leaveApplicationRepository;



}
