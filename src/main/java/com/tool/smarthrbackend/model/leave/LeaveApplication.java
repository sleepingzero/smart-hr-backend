package com.tool.smarthrbackend.model.leave;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tool.smarthrbackend.model.employee.Employee;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="employee_leave_application")
@ToString
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;


    @Transient
    @JsonProperty
    Long  employeeId;

    @ManyToOne
    @JoinColumn(name="employee_id")
    Employee emp;

    @Transient
    @JsonProperty
    Long leaveTypeId;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    LeaveType leaveType;

    @Column(name = "from_date")
    Date fromDate;

    @Column(name = "to_date")
    Date toDate;

    @Column(name = "from_date_half")
    Integer fromDateHalf;



    @Column(name = "to_date_half")
    Integer toDateHalf;


    @Column(name = "created_date" ,updatable = false)
    Date createdDate;


    @Column(name = "updated_date")
    Date updatedDate;

    @Column(name = "total_leave_days")
    double totalLeaveDays;

    @Column(name= "leave_status_id")
    Integer leaveStatusId;

    @Column(name = "leave_status")
    String leaveStatus;

    @Column(name= "leave_reason")
    String leaveReason;

    @Column(name = "approved_by_id")
    Long approvedById;


    public LeaveApplication() {
    }

    public LeaveApplication(Long id, Long employeeId, Employee emp, Long leaveTypeId, LeaveType leaveType, Date fromDate, Date toDate, Integer fromDateHalf, Integer toDateHalf, Date createdDate, Date updatedDate, double totalLeaveDays, Integer leaveStatusId, String leaveStatus, String leaveReason, Long approvedById) {
        this.id = id;
        this.employeeId = employeeId;
        this.emp = emp;
        this.leaveTypeId = leaveTypeId;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromDateHalf = fromDateHalf;
        this.toDateHalf = toDateHalf;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.totalLeaveDays = totalLeaveDays;
        this.leaveStatusId = leaveStatusId;
        this.leaveStatus = leaveStatus;
        this.leaveReason = leaveReason;
        this.approvedById = approvedById;
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

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Long getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Long leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
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

    public Integer getFromDateHalf() {
        return fromDateHalf;
    }

    public void setFromDateHalf(Integer fromDateHalf) {
        this.fromDateHalf = fromDateHalf;
    }

    public Integer getToDateHalf() {
        return toDateHalf;
    }

    public void setToDateHalf(Integer toDateHalf) {
        this.toDateHalf = toDateHalf;
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

    public double getTotalLeaveDays() {
        return totalLeaveDays;
    }

    public void setTotalLeaveDays(double totalLeaveDays) {
        this.totalLeaveDays = totalLeaveDays;
    }

    public Integer getLeaveStatusId() {
        return leaveStatusId;
    }

    public void setLeaveStatusId(Integer leaveStatusId) {
        this.leaveStatusId = leaveStatusId;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public Long getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(Long approvedById) {
        this.approvedById = approvedById;
    }
}
