package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "asset")
@ToString
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "emp_id")
    Integer empId;

    @Column(name = "asset_type")
    String assetType;

    @Column(name = "asset_model_no")
    String assetModelNo;

    @Column(name = "asset_issue_date")
    LocalDate assetIssueDate;

    @Column(name = "asset_return_date")
    LocalDate assetReturnDate;

    @Column(name = "created_by")
    String createdBy;

    @Column(name = "updated_by")
    String updatedBy;

    @Column(name = "status")
    String status;

    @Column(name = "asset_description")
    String assetDescription;


    public Asset() {
    }

    public Asset(Long id, Integer empId, String assetType, String assetModelNo, LocalDate assetIssueDate, LocalDate assetReturnDate, String createdBy, String updatedBy, String status, String assetDescription) {
        this.id = id;
        this.empId = empId;
        this.assetType = assetType;
        this.assetModelNo = assetModelNo;
        this.assetIssueDate = assetIssueDate;
        this.assetReturnDate = assetReturnDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.status = status;
        this.assetDescription = assetDescription;
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

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetModelNo() {
        return assetModelNo;
    }

    public void setAssetModelNo(String assetModelNo) {
        this.assetModelNo = assetModelNo;
    }

    public LocalDate getAssetIssueDate() {
        return assetIssueDate;
    }

    public void setAssetIssueDate(LocalDate assetIssueDate) {
        this.assetIssueDate = assetIssueDate;
    }

    public LocalDate getAssetReturnDate() {
        return assetReturnDate;
    }

    public void setAssetReturnDate(LocalDate assetReturnDate) {
        this.assetReturnDate = assetReturnDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }
}
