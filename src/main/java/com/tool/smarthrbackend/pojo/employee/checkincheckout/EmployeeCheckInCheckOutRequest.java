package com.tool.smarthrbackend.pojo.employee.checkincheckout;

public class EmployeeCheckInCheckOutRequest
{
Integer employeeId;
Boolean status;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
