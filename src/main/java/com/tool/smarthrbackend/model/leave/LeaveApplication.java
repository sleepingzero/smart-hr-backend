package com.tool.smarthrbackend.model.leave;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tool.smarthrbackend.model.employee.Employee;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="EMPLOYEE_LEAVE_APPLICATION")
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


}
