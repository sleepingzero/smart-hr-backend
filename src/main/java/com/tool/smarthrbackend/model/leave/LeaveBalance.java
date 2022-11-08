package com.tool.smarthrbackend.model.leave;

import com.tool.smarthrbackend.model.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="employee_leave_balances")
public class LeaveBalance {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    LeaveType leaveType;

    @Column(name = "leave_balance")
    double leaveBalance;

    @Column(name = "provided_leave_balance")
    Long providedLeaveBalance;



    @Column(name = "created_date",updatable = false)
    Date createdDate;

    @Column(name = "updated_date")
    Date updatedDate;

    @Column(name="last_leave_app_id")
    Long lastLeaveAppId;


    public LeaveBalance() {
    }

    public LeaveBalance(Long id, Employee employee, LeaveType leaveType, double leaveBalance, Long providedLeaveBalance, Date createdDate, Date updatedDate, Long lastLeaveAppId) {
        this.id = id;
        this.employee = employee;
        this.leaveType = leaveType;
        this.leaveBalance = leaveBalance;
        this.providedLeaveBalance = providedLeaveBalance;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.lastLeaveAppId = lastLeaveAppId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public Long getProvidedLeaveBalance() {
        return providedLeaveBalance;
    }

    public void setProvidedLeaveBalance(Long providedLeaveBalance) {
        this.providedLeaveBalance = providedLeaveBalance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getLastLeaveAppId() {
        return lastLeaveAppId;
    }

    public void setLastLeaveAppId(Long lastLeaveAppId) {
        this.lastLeaveAppId = lastLeaveAppId;
    }
}
