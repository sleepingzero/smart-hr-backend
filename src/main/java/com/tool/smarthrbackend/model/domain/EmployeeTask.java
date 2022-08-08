package com.tool.smarthrbackend.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_task")
public class EmployeeTask {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name="task_name")
    String taskName;

    @ManyToOne
    @JoinColumn (name="project_id")
    private  EmployeeProject employeeProject;

    public EmployeeTask() {
    }

    public EmployeeTask(Long id, String taskName, EmployeeProject employeeProject) {
        this.id = id;
        this.taskName = taskName;
        this.employeeProject = employeeProject;
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

    public EmployeeProject getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProject employeeProject) {
        this.employeeProject = employeeProject;
    }
}
