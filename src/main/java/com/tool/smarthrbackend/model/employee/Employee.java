package com.tool.smarthrbackend.model.employee;

import com.fasterxml.jackson.annotation.*;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.model.metadata.Role;
import com.tool.smarthrbackend.model.domain.Domain;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name ="employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "manager_id")
     Long managerId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "middle_name")
    String middleName;

    @Column(name = "personal_email_id")
    String personalEmailId;

    @Column(name = "professional_email_id")
    String professionalEmailId;

    @Column(name = "date_of_joining")
    String dateOfJoining;


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
    @JoinColumn(name = "shift_id")
    private AttendanceShifts attendanceShifts;


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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private List<Asset> assets;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "personal_detail_id")

    @Column(name = "personal_detail_id")
    Long personalDetailId;

    @Transient
    @JsonProperty
    public EmployeePersonalDetail employeePersonalDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_detail_id")
    public EmployeeFamilyDetail employeeFamilyDetail;



    public Employee() {
    }

    public Employee(Long id, Long managerId, String firstName, String middleName, String personalEmailId, String professionalEmailId, String dateOfJoining, String lastName, Long phoneNumber, String empPassword, Department department, AttendanceShifts attendanceShifts, Role role, Long projectId, Domain designation, Long tmpPasswordOtp, List<EmployeeAddress> employeeAddresses, List<EmployeeEducation> employeeEducations, List<EmployeeProfessionalDetail> employeeProfessionalDetails, List<Asset> assets, Long personalDetailId, EmployeePersonalDetail employeePersonalDetail, EmployeeFamilyDetail employeeFamilyDetail) {
        this.id = id;
        this.managerId = managerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.personalEmailId = personalEmailId;
        this.professionalEmailId = professionalEmailId;
        this.dateOfJoining = dateOfJoining;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.empPassword = empPassword;
        this.department = department;
        this.attendanceShifts = attendanceShifts;
        this.role = role;
        this.projectId = projectId;
        this.designation = designation;
        this.tmpPasswordOtp = tmpPasswordOtp;
        this.employeeAddresses = employeeAddresses;
        this.employeeEducations = employeeEducations;
        this.employeeProfessionalDetails = employeeProfessionalDetails;
        this.assets = assets;
        this.personalDetailId = personalDetailId;
        this.employeePersonalDetail = employeePersonalDetail;
        this.employeeFamilyDetail = employeeFamilyDetail;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
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

    public AttendanceShifts getAttendanceShifts() {
        return attendanceShifts;
    }

    public void setAttendanceShifts(AttendanceShifts attendanceShifts) {
        this.attendanceShifts = attendanceShifts;
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

    public Long getPersonalDetailId() {
        return personalDetailId;
    }

    public void setPersonalDetailId(Long personalDetailId) {
        this.personalDetailId = personalDetailId;
    }

    public EmployeePersonalDetail getEmployeePersonalDetail() {
        return employeePersonalDetail;
    }

    public void setEmployeePersonalDetail(EmployeePersonalDetail employeePersonalDetail) {
        this.employeePersonalDetail = employeePersonalDetail;
    }

    public EmployeeFamilyDetail getEmployeeFamilyDetail() {
        return employeeFamilyDetail;
    }

    public void setEmployeeFamilyDetail(EmployeeFamilyDetail employeeFamilyDetail) {
        this.employeeFamilyDetail = employeeFamilyDetail;
    }
}