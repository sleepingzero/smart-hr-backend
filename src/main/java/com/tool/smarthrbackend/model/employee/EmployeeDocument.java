package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name ="employee_documents")
@ToString
public class EmployeeDocument {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "doc_name")
    String documentName;

    @Column(name = "doc_number")
    String documentNo;

    @Column(name = "emp_id")
    Integer empId;

    public EmployeeDocument() {
    }

    public EmployeeDocument(Long id, String documentName, String documentNo, Integer empId) {
        this.id = id;
        this.documentName = documentName;
        this.documentNo = documentNo;
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }
}
