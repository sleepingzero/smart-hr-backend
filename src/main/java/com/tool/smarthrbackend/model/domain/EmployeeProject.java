package com.tool.smarthrbackend.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee_project")
public class EmployeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Long id;

    @Column(name = "project_name")
    String projectName;

    public EmployeeProject() {
    }

    public EmployeeProject(Long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
