package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employee_education_details")
@ToString
public class EmployeeEducation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_id")
    Integer empId;

    @Column(name = "institute")
     String institute;

    @Column(name = "degree")
    String degree;

    @Column(name = "specialization")
    String specialization;

    @Column(name = "grade")
    String grade;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;


    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    @Column(name = "country")
    String country;

    @Column(name = "pincode")
    String pincode;


    public EmployeeEducation() {
    }

    public EmployeeEducation(Long id, Integer empId, String institute, String degree, String specialization, String grade, Date startDate, Date endDate, String city, String state, String country, String pincode) {
        this.id = id;
        this.empId = empId;
        this.institute = institute;
        this.degree = degree;
        this.specialization = specialization;
        this.grade = grade;
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

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
