package com.tool.smarthrbackend.model.employee;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "employee_personal_details")
@ToString
public class EmployeePersonalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    public Employee employee;

    @Column(name = "date_of_birth")
    LocalDate date;

    @Column(name = "gender")
    String gender;

    @Column(name = "marital_status")
    String maritalStatus;

    @Column(name = "blood_group")
    String bloodGroup;

    @Column(name = "nationality")
    String nationality;

    public EmployeePersonalDetail() {
    }

    public EmployeePersonalDetail(Long id, Employee employee, LocalDate date, String gender, String maritalStatus, String bloodGroup, String nationality) {
        this.id = id;
        this.employee = employee;
        this.date = date;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.bloodGroup = bloodGroup;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}