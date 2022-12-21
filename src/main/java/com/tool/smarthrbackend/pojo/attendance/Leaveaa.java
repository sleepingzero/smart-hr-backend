package com.tool.smarthrbackend.pojo.attendance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Leaveaa {
    List<Long> empIdList;
    Date fromDate;
    Date toDate;

    public List<Long> getEmpIdList() {
        return empIdList;
    }

    public void setEmpIdList(List<Long> empIdList) {
        this.empIdList = empIdList;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
