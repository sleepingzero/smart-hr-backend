package com.tool.smarthrbackend.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.model.metadata.Role;
import com.tool.smarthrbackend.model.domain.Domain;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name ="employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "middle_name")
    String middleName;

    @Column(name = "personal_email_id")
    String personalEmailId;

    @Column(name = "professional_email_id")
    String professionalEmailId;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "phone_number")
    Long  phoneNumber;

    @Column(name = "emp_password")
    String empPassword;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    @Column(name = "project_id")
    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Domain designation;

    @Column(name = "tmp_password_otp")
    private Long tmpPasswordOtp;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private List<EmployeeAddress> employeeAddresses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private List<EmployeeEducation> employeeEducations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private List<EmployeeProfessionalDetail> employeeProfessionalDetails;

    @OneToOne(cascade = CascadeType.ALL)
    public EmployeePersonalDetail employeePersonalDetail;

//    @JsonManagedReference // this for parent to avoid infinite recursion
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_personal_detail_id") // B table foreign key in A table
//    public EmployeePersonalDetail employeePersonalDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_detail_id")
    public EmployeeFamilyDetail employeeFamilyDetail;

    public Employee() {
    }


    public Employee(Long id, String name, String middleName, String personalEmailId, String professionalEmailId, String lastName, Long phoneNumber, String empPassword, Department department, Role role, Long projectId, Domain designation, Long tmpPasswordOtp, List<EmployeeAddress> employeeAddresses, List<EmployeeEducation> employeeEducations, List<EmployeeProfessionalDetail> employeeProfessionalDetails, EmployeePersonalDetail employeePersonalDetail, EmployeeFamilyDetail employeeFamilyDetail) {
        this.id = id;
        this.name = name;
        this.middleName = middleName;
        this.personalEmailId = personalEmailId;
        this.professionalEmailId = professionalEmailId;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.empPassword = empPassword;
        this.department = department;
        this.role = role;
        this.projectId = projectId;
        this.designation = designation;
        this.tmpPasswordOtp = tmpPasswordOtp;
        this.employeeAddresses = employeeAddresses;
        this.employeeEducations = employeeEducations;
        this.employeeProfessionalDetails = employeeProfessionalDetails;
        this.employeePersonalDetail = employeePersonalDetail;
        this.employeeFamilyDetail = employeeFamilyDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeFamilyDetail getEmployeeFamilyDetail() {
        return employeeFamilyDetail;
    }

    public void setEmployeeFamilyDetail(EmployeeFamilyDetail employeeFamilyDetail) {
        this.employeeFamilyDetail = employeeFamilyDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPersonalEmailId() {
        return personalEmailId;
    }

    public void setPersonalEmailId(String personalEmailId) {
        this.personalEmailId = personalEmailId;
    }

    public String getProfessionalEmailId() {
        return professionalEmailId;
    }

    public void setProfessionalEmailId(String professionalEmailId) {
        this.professionalEmailId = professionalEmailId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Domain getDesignation() {
        return designation;
    }

    public void setDesignation(Domain designation) {
        this.designation = designation;
    }

    public Long getTmpPasswordOtp() {
        return tmpPasswordOtp;
    }

    public void setTmpPasswordOtp(Long tmpPasswordOtp) {
        this.tmpPasswordOtp = tmpPasswordOtp;
    }

    public List<EmployeeAddress> getEmployeeAddresses() {
        return employeeAddresses;
    }

    public void setEmployeeAddresses(List<EmployeeAddress> employeeAddresses) {
        this.employeeAddresses = employeeAddresses;
    }

    public List<EmployeeEducation> getEmployeeEducations() {
        return employeeEducations;
    }

    public void setEmployeeEducations(List<EmployeeEducation> employeeEducations) {
        this.employeeEducations = employeeEducations;
    }

    public List<EmployeeProfessionalDetail> getEmployeeProfessionalDetails() {
        return employeeProfessionalDetails;
    }

    public void setEmployeeProfessionalDetails(List<EmployeeProfessionalDetail> employeeProfessionalDetails) {
        this.employeeProfessionalDetails = employeeProfessionalDetails;
    }

    public EmployeePersonalDetail getEmployeePersonalDetail() {
        return employeePersonalDetail;
    }

    public void setEmployeePersonalDetail(EmployeePersonalDetail employeePersonalDetail) {
        this.employeePersonalDetail = employeePersonalDetail;
    }
}