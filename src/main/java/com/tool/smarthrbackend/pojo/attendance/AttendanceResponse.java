package com.tool.smarthrbackend.pojo.attendance;

import com.tool.smarthrbackend.model.attendance.Attendance;
import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class AttendanceResponse {
 Long empId;

 LocalDate date;
 String empfirstName;
 String empMiddleName;
 String empLastName;
 Attendance attendance;
 List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList;

    public String getEmpfirstName() {
        return empfirstName;
    }

    public void setEmpfirstName(String empfirstName) {
        this.empfirstName = empfirstName;
    }

    public String getEmpMiddleName() {
        return empMiddleName;
    }

    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

      public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public List<EmployeeCheckInCheckOut> getEmployeeCheckInCheckOutList() {
        return employeeCheckInCheckOutList;
    }

    public void setEmployeeCheckInCheckOutList(List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList) {
        this.employeeCheckInCheckOutList = employeeCheckInCheckOutList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
