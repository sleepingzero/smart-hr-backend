package com.tool.smarthrbackend.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project_task")
public class EmployeeProjectTask {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name="task_name")
    String taskName;

    @Column(name="task_description")
    String taskDescription;

    @ManyToOne
    @JoinColumn (name="project_id")
    public  EmployeeProject employeeProject;

    @Column(name = "active_status")
    Boolean activeStatus;


    public EmployeeProjectTask() {
    }

    public EmployeeProjectTask(Long id, String taskName, String taskDescription, EmployeeProject employeeProject, Boolean activeStatus) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.employeeProject = employeeProject;
        this.activeStatus = activeStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public EmployeeProject getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProject employeeProject) {
        this.employeeProject = employeeProject;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
