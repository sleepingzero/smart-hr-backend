package com.tool.smarthrbackend.model.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name ="attendance")
@ToString
public class Attendance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Transient
    @JsonProperty
    Long empId;

    @ManyToOne

    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    Employee employee;

    @Transient
    @JsonProperty
    Long shiftId;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    AttendanceShifts attendanceShifts;

    @Column(name = "date")
    LocalDate date;

    @Transient
    @JsonProperty
    @OneToMany
    List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList;



    public Attendance() {
    }

    public Attendance(Long id, Long empId, Employee employee, Long shiftId, AttendanceShifts attendanceShifts, LocalDate date, List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList) {
        this.id = id;
        this.empId = empId;
        this.employee = employee;
        this.shiftId = shiftId;
        this.attendanceShifts = attendanceShifts;
        this.date = date;
        this.employeeCheckInCheckOutList = employeeCheckInCheckOutList;
    }


    public List<EmployeeCheckInCheckOut> getEmployeeCheckInCheckOutList() {
        return employeeCheckInCheckOutList;
    }

    public void setEmployeeCheckInCheckOutList(List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList) {
        this.employeeCheckInCheckOutList = employeeCheckInCheckOutList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public AttendanceShifts getAttendanceShifts() {
        return attendanceShifts;
    }

    public void setAttendanceShifts(AttendanceShifts attendanceShifts) {
        this.attendanceShifts = attendanceShifts;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
