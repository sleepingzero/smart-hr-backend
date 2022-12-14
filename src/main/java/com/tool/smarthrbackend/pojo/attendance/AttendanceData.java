package com.tool.smarthrbackend.pojo.attendance;

import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class AttendanceData {
    Long AttendanceId;
    Long EmployeeId;
    Long ManagerId;
    LocalDate date;
    String firstName;
    String LastName;
    String MiddleName;

    String Status;
    Integer totalWorkHours;
    AttendanceShifts attendanceShifts;
    List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Long getAttendanceId() {
        return AttendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        AttendanceId = attendanceId;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public Long getManagerId() {
        return ManagerId;
    }

    public void setManagerId(Long managerId) {
        ManagerId = managerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public Integer getTotalWorkHours() {
        return totalWorkHours;
    }

    public void setTotalWorkHours(Integer totalWorkHours) {
        this.totalWorkHours = totalWorkHours;
    }

    public AttendanceShifts getAttendanceShifts() {
        return attendanceShifts;
    }

    public void setAttendanceShifts(AttendanceShifts attendanceShifts) {
        this.attendanceShifts = attendanceShifts;
    }

    public List<EmployeeCheckInCheckOut> getEmployeeCheckInCheckOutList() {
        return employeeCheckInCheckOutList;
    }

    public void setEmployeeCheckInCheckOutList(List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList) {
        this.employeeCheckInCheckOutList = employeeCheckInCheckOutList;
    }
}
