package com.tool.smarthrbackend.pojo.attendance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class LeaveAttendanceResponse {
    List<Long> empIdList;
    LocalDate fromDate;
    LocalDate toDate;

    public List<Long> getEmpIdList() {
        return empIdList;
    }

    public void setEmpIdList(List<Long> empIdList) {
        this.empIdList = empIdList;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
