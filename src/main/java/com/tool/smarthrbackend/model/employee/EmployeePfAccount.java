package com.tool.smarthrbackend.model.employee;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_pf_details")
@ToString
public class EmployeePfAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;


    @Column(name = "UAN")
    String uan;

    @Column(name = "pf_number")
    Long pfNumber;

    @Column(name = "aadhar_no")
    Long aadharNo;

    @Column(name = "bank_account_no")
    Long bankAccountNumber;

    @Column(name = "mobile_no")
    Long mobileNumber;


    public EmployeePfAccount() {
    }

    public EmployeePfAccount(Long id, String uan, Long pfNumber, Long aadharNo, Long bankAccountNumber, Long mobileNumber) {
        this.id = id;
        this.uan = uan;
        this.pfNumber = pfNumber;
        this.aadharNo = aadharNo;
        this.bankAccountNumber = bankAccountNumber;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUan() {
        return uan;
    }

    public void setUan(String uan) {
        this.uan = uan;
    }

    public Long getPfNumber() {
        return pfNumber;
    }

    public void setPfNumber(Long pfNumber) {
        this.pfNumber = pfNumber;
    }

    public Long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(Long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public Long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(Long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
