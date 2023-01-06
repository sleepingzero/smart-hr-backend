package com.tool.smarthrbackend.model.employee;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name="employee_bank_account_details")
public class EmployeeBankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Long id;


    @Column(name="bank_name")
    String bankName;

    @Column(name="account_holder_name")
    String accountHolderName;

    @Column(name="account_no")
    Long accountNo;

    @Column(name="ifsc")
    String ifsc;

    public EmployeeBankAccount() {
    }

    public EmployeeBankAccount(Long id, String bankName, String accountHolderName, Long accountNo, String ifsc) {
        this.id = id;
        this.bankName = bankName;
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        this.ifsc = ifsc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
}