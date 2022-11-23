package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="employee_professional_detail")
@ToString
public class EmployeeProfessionalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_id")
    Integer empId;

    @Column(name = "company")
    String company;

    @Column(name = "designation")
    String designation;

    @Column(name = "roles_responsibility")
    String roleAndResponsibility;

    @Column(name = "skill")
    String skill;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;


    @Column(name = "city")
    Integer city;

    @Column(name = "state")
    Integer state;

    @Column(name = "country")
    Integer country;

    @Column(name = "pincode")
    String pincode;

    public EmployeeProfessionalDetail() {
    }

    public EmployeeProfessionalDetail(Long id, Integer empId, String company, String designation, String roleAndResponsibility, String skill, Date startDate, Date endDate, Integer city, Integer state, Integer country, String pincode) {
        this.id = id;
        this.empId = empId;
        this.company = company;
        this.designation = designation;
        this.roleAndResponsibility = roleAndResponsibility;
        this.skill = skill;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRoleAndResponsibility() {
        return roleAndResponsibility;
    }

    public void setRoleAndResponsibility(String roleAndResponsibility) {
        this.roleAndResponsibility = roleAndResponsibility;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}