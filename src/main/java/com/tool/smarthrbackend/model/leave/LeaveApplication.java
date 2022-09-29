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

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "created_date" ,updatable = false)
    Date createdDate;


    @Column(name = "updated_date")
    Date updatedDate;

    @Column(name = "start_date_half")
    Integer startDateHalf;

    @Column(name = "end_date")
    Date endDate;

    @Column(name = "end_date_half")
    Integer endDateHalf;


    @Column(name = "total_leave_days")
    Integer totalLeaveDays;

    @Column(name= "leave_reason_id")
    Integer leaveReasonId;

    @Column(name= "leave_status_id")
    Integer leaveStatusId;

    @Column(name = "leave_status")
    String leaveStatus;

    @Column(name= "leave_description")
    String leaveDescription;


    public LeaveApplication() {
    }

    public LeaveApplication(Long id, Long employeeId, Employee emp, Long leaveTypeId, LeaveType leaveType, Date startDate, Date createdDate, Date updatedDate, Integer startDateHalf, Date endDate, Integer endDateHalf, Integer totalLeaveDays, Integer leaveReasonId, Integer leaveStatusId, String leaveStatus, String leaveDescription) {
        this.id = id;
        this.employeeId = employeeId;
        this.emp = emp;
        this.leaveTypeId = leaveTypeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.startDateHalf = startDateHalf;
        this.endDate = endDate;
        this.endDateHalf = endDateHalf;
        this.totalLeaveDays = totalLeaveDays;
        this.leaveReasonId = leaveReasonId;
        this.leaveStatusId = leaveStatusId;
        this.leaveStatus = leaveStatus;
        this.leaveDescription = leaveDescription;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Integer getStartDateHalf() {
        return startDateHalf;
    }

    public void setStartDateHalf(Integer startDateHalf) {
        this.startDateHalf = startDateHalf;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getEndDateHalf() {
        return endDateHalf;
    }

    public void setEndDateHalf(Integer endDateHalf) {
        this.endDateHalf = endDateHalf;
    }

    public Integer getTotalLeaveDays() {
        return totalLeaveDays;
    }

    public void setTotalLeaveDays(Integer totalLeaveDays) {
        this.totalLeaveDays = totalLeaveDays;
    }

    public Integer getLeaveReasonId() {
        return leaveReasonId;
    }

    public void setLeaveReasonId(Integer leaveReasonId) {
        this.leaveReasonId = leaveReasonId;
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

    public String getLeaveDescription() {
        return leaveDescription;
    }

    public void setLeaveDescription(String leaveDescription) {
        this.leaveDescription = leaveDescription;
    }
}
