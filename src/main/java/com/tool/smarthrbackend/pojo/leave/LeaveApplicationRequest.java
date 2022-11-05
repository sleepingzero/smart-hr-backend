package com.tool.smarthrbackend.pojo.leave;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveApplicationRequest {
    Long id;
    Long employeeId;
    Long leaveTypeId;
    Date fromDate;
    Integer fromDateHalf;
    Date toDate;
    Integer toDateHalf;
    double totalLeaveDays ;
}
