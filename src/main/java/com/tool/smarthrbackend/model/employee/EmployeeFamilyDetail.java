package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee_family_detail")
@ToString

public class EmployeeFamilyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "emp_id")
    Integer empId;

    @Column(name="relation")
    String relation;

    @Column(name = "name")
    String nameRelative;

    @Column(name = "occupation")
    String occupationRelative;

    @Column(name = "dob")
    LocalDate dobOfRelative;

    @Column(name = "is_dependent")
    Integer isDependent;

    public EmployeeFamilyDetail() {
    }

    public EmployeeFamilyDetail(Long id, Integer empId, String relation, String nameRelative, String occupationRelative, LocalDate dobOfRelative, Integer isDependent) {
        this.id = id;
        this.empId = empId;
        this.relation = relation;
        this.nameRelative = nameRelative;
        this.occupationRelative = occupationRelative;
        this.dobOfRelative = dobOfRelative;
        this.isDependent = isDependent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNameRelative() {
        return nameRelative;
    }

    public void setNameRelative(String nameRelative) {
        this.nameRelative = nameRelative;
    }

    public String getOccupationRelative() {
        return occupationRelative;
    }

    public void setOccupationRelative(String occupationRelative) {
        this.occupationRelative = occupationRelative;
    }

    public LocalDate getDobOfRelative() {
        return dobOfRelative;
    }

    public void setDobOfRelative(LocalDate dobOfRelative) {
        this.dobOfRelative = dobOfRelative;
    }

    public Integer getIsDependent() {
        return isDependent;
    }

    public void setIsDependent(Integer isDependent) {
        this.isDependent = isDependent;
    }
}
