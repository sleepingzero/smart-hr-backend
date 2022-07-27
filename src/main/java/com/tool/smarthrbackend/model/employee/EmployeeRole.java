package com.tool.smarthrbackend.model.employee;

import com.tool.smarthrbackend.model.leave.LeaveType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name ="employee_role")
public class EmployeeRole {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    LeaveType leaveType;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;


}
