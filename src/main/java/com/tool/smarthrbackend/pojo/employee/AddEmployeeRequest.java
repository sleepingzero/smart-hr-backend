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
    List<EmployeeAddress> employeeAddresseList;
    List<EmployeeEducation> employeeEducationList;

    List<EmployeeProfessionalDetail> employeeProfessionalDetailList;
    EmployeePersonalDetail employeePersonalDetail;

    List<EmployeeFamilyDetail> employeeFamilyDetailList;

    EmployeePfAccount employeePfAccount;
    EmployeeBankAccount employeeBankAccount;
    List<Asset> assetsList;

    List<EmployeeSkill> employeeSkillList;

    List<EmployeeDocument> employeeDocumentList;


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

    public List<EmployeeAddress> getEmployeeAddresseList() {
        return employeeAddresseList;
    }

    public void setEmployeeAddresseList(List<EmployeeAddress> employeeAddresseList) {
        this.employeeAddresseList = employeeAddresseList;
    }

    public List<EmployeeEducation> getEmployeeEducationList() {
        return employeeEducationList;
    }

    public void setEmployeeEducationList(List<EmployeeEducation> employeeEducationList) {
        this.employeeEducationList = employeeEducationList;
    }

    public List<EmployeeProfessionalDetail> getEmployeeProfessionalDetailList() {
        return employeeProfessionalDetailList;
    }

    public void setEmployeeProfessionalDetailList(List<EmployeeProfessionalDetail> employeeProfessionalDetailList) {
        this.employeeProfessionalDetailList = employeeProfessionalDetailList;
    }

    public EmployeePersonalDetail getEmployeePersonalDetail() {
        return employeePersonalDetail;
    }

    public void setEmployeePersonalDetail(EmployeePersonalDetail employeePersonalDetail) {
        this.employeePersonalDetail = employeePersonalDetail;
    }

    public List<EmployeeFamilyDetail> getEmployeeFamilyDetailList() {
        return employeeFamilyDetailList;
    }

    public void setEmployeeFamilyDetailList(List<EmployeeFamilyDetail> employeeFamilyDetailList) {
        this.employeeFamilyDetailList = employeeFamilyDetailList;
    }

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

    public List<Asset> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Asset> assetsList) {
        this.assetsList = assetsList;
    }

    public List<EmployeeSkill> getEmployeeSkillList() {
        return employeeSkillList;
    }

    public void setEmployeeSkillList(List<EmployeeSkill> employeeSkillList) {
        this.employeeSkillList = employeeSkillList;
    }

    public List<EmployeeDocument> getEmployeeDocumentList() {
        return employeeDocumentList;
    }

    public void setEmployeeDocumentList(List<EmployeeDocument> employeeDocumentList) {
        this.employeeDocumentList = employeeDocumentList;
    }
}
