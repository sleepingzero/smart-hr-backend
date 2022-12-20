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

    @Column(name = "project_description")
    String projectDescription;


    public EmployeeProject() {
    }

    public EmployeeProject(Long id, String projectName, String projectDescription) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
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
