package com.tool.smarthrbackend.pojo.employee;

import com.tool.smarthrbackend.model.employee.*;
import com.tool.smarthrbackend.model.metadata.Department;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AddEmployeeRequest {

    String name;
    String middleName;
    String personalEmailId;
    String professionalEmailId;
    String lastName;
    Long departmentId;
    Long employeeRoleId;
    Long designationId;
    Boolean isFirstTimeCreation;
    Long phoneNumber;


    Long managerId;
//    List<Long> managerIds;
//    List<Long> roles;
    List<EmployeeAddress> employeeAddresses;
    List<EmployeeEducation> employeeEducations;

    List<EmployeeProfessionalDetail> employeeProfessionalDetails;
    EmployeePersonalDetail employeePersonalDetail;

    EmployeeFamilyDetail employeeFamilyDetail;

    public List<EmployeeEducation> getEmployeeEducations() {
        return employeeEducations;
    }

    public void setEmployeeEducations(List<EmployeeEducation> employeeEducations) {
        this.employeeEducations = employeeEducations;
    }

    public EmployeeFamilyDetail getEmployeeFamilyDetail() {
        return employeeFamilyDetail;
    }

    public void setEmployeeFamilyDetail(EmployeeFamilyDetail employeeFamilyDetail) {
        this.employeeFamilyDetail = employeeFamilyDetail;
    }

    public EmployeePersonalDetail getEmployeePersonalDetail() {
        return employeePersonalDetail;
    }

    public void setEmployeePersonalDetail(EmployeePersonalDetail employeePersonalDetail) {
        this.employeePersonalDetail = employeePersonalDetail;
    }

    public List<EmployeeProfessionalDetail> getEmployeeProfessionalDetails() {
        return employeeProfessionalDetails;
    }

    public void setEmployeeProfessionalDetails(List<EmployeeProfessionalDetail> employeeProfessionalDetails) {
        this.employeeProfessionalDetails = employeeProfessionalDetails;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getEmployeeRoleId() {
        return employeeRoleId;
    }

    public void setEmployeeRoleId(Long employeeRoleId) {
        this.employeeRoleId = employeeRoleId;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public Boolean getFirstTimeCreation() {
        return isFirstTimeCreation;
    }

    public void setFirstTimeCreation(Boolean firstTimeCreation) {
        isFirstTimeCreation = firstTimeCreation;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<EmployeeAddress> getEmployeeAddresses() {
        return employeeAddresses;
    }

    public void setEmployeeAddresses(List<EmployeeAddress> employeeAddresses) {
        this.employeeAddresses = employeeAddresses;
    }
}
