package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="employee_checkin_checkout")
@ToString
public class EmployeeCheckInCheckOut {


        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "id")
        Long id;



        @Column(name = "emp_id")
     Long employeeId;

       @Column(name="check_in_check_out_time")

       LocalDateTime checkInCheckOutTime;

        @Column(name="status")
        Boolean status;

        @Column(name = "date")
        LocalDate date;

        @Column(name = "duration")
        Integer workDuration;





    public EmployeeCheckInCheckOut() {
    }


    public EmployeeCheckInCheckOut(Long id, Long employeeId, LocalDateTime checkInCheckOutTime, Boolean status, LocalDate date, Integer workDuration) {
        this.id = id;
        this.employeeId = employeeId;
        this.checkInCheckOutTime = checkInCheckOutTime;
        this.status = status;
        this.date = date;
        this.workDuration = workDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getCheckInCheckOutTime() {
        return checkInCheckOutTime;
    }

    public void setCheckInCheckOutTime(LocalDateTime checkInCheckOutTime) {
        this.checkInCheckOutTime = checkInCheckOutTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(Integer workDuration) {
        this.workDuration = workDuration;
    }
}
