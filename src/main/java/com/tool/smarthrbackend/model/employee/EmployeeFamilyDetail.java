package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_family_detail")
@ToString

public class EmployeeFamilyDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name="father_name")
    String fatherName;

    @Column(name="mother_name")
    String motherName;

    @Column(name="father_occupation")
    String fatherOccupation;

    @Column(name="mother_occupation")
    String  motherOccupation;

    @Column(name="spouse_name")
    String spouseName;

    public EmployeeFamilyDetail() {
    }

    public EmployeeFamilyDetail(Long id,  String fatherName, String motherName, String fatherOccupation, String motherOccupation, String spouseName) {
        this.id = id;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherOccupation = fatherOccupation;
        this.motherOccupation = motherOccupation;
        this.spouseName = spouseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }
}
