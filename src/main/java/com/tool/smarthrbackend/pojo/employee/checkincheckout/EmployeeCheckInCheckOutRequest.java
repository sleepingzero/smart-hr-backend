package com.tool.smarthrbackend.pojo.employee.checkincheckout;

public class EmployeeCheckInCheckOutRequest
{
Long employeeId;
Boolean status;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
