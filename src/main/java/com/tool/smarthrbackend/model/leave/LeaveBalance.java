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
    Long leaveBalance;

    @Column(name = "provided_leave_balance")
    Long providedLeaveBalance;



    @Column(name = "created_date",updatable = false)
    Date createdDate;

    @Column(name = "updated_date")
    Date updatedDate;

    @Column(name="last_leave_app_id")
    Long lastLeaveAppId;

}
