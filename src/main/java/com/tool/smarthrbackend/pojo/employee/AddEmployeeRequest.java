package com.tool.smarthrbackend.pojo.employee;

import com.tool.smarthrbackend.model.employee.*;
import com.tool.smarthrbackend.model.metadata.Department;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class AddEmployeeRequest {

    String firstName;
    String middleName;
    String personalEmailId;
    String professionalEmailId;
    String lastName;
    Long departmentId;

    Long attendanceShiftId;
    Long employeeRoleId;
    Long designationId;
    Boolean isFirstTimeCreation;
    Long phoneNumber;

    Date dateOfJoining;
    Long managerId;
    //    List<Long> managerIds;
//    List<Long> roles;
    List<EmployeeAddress> employeeAddresses;
    List<EmployeeEducation> employeeEducations;

    List<EmployeeProfessionalDetail> employeeProfessionalDetails;
    EmployeePersonalDetail employeePersonalDetail;

    List<EmployeeFamilyDetail> employeeFamilyDetailList;

    EmployeePfAccount employeePfAccount;
    EmployeeBankAccount employeeBankAccount;
    List<Asset> assets;


    public EmployeePfAccount getEmployeePfAccount() {
        return employeePfAccount;
    }

    public void setEmployeePfAccount(EmployeePfAccount employeePfAccount) {
        this.employeePfAccount = employeePfAccount;
    }

    public EmployeeBankAccount getEmployeeBankAccount() {
        return employeeBankAccount;
    }

    public void setEmployeeBankAccount(EmployeeBankAccount employeeBankAccount) {
        this.employeeBankAccount = employeeBankAccount;
    }

    public List<EmployeeFamilyDetail> getEmployeeFamilyDetailList() {
        return employeeFamilyDetailList;
    }

    public void setEmployeeFamilyDetailList(List<EmployeeFamilyDetail> employeeFamilyDetailList) {
        this.employeeFamilyDetailList = employeeFamilyDetailList;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
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

    public String getProfessionalEmailId() {
        return professionalEmailId;
    }

    public void setProfessionalEmailId(String professionalEmailId) {
        this.professionalEmailId = professionalEmailId;
    }

    public String getPersonalEmailId() {
        return personalEmailId;
    }

    public void setPersonalEmailId(String personalEmailId) {
        this.personalEmailId = personalEmailId;
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

    public Long getAttendanceShiftId() {
        return attendanceShiftId;
    }

    public void setAttendanceShiftId(Long attendanceShiftId) {
        this.attendanceShiftId = attendanceShiftId;
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

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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
