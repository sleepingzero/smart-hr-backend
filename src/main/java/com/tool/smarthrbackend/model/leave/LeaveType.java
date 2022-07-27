package com.tool.smarthrbackend.model.leave;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LEAVE_TYPES")
public class LeaveType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @Column(name= "LEAVE_TYPE_NAME")
    String leaveTypeName;

    @Column(name= "LEAVE_TYPE_DESCRIPTION")
    String leaveTypeDescription;

}
