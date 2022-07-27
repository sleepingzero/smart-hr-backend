package com.tool.smarthrbackend.model.metadata;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @Column(name= "dept_name")
    String deptName;


    @Column(name= "dept_type")
    String deptType;

    @Column(name= "dept_desc")
    String deptDesc;

    @Column(name = "status")
    Integer status;
}
