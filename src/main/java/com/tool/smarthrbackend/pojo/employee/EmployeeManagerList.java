package com.tool.smarthrbackend.pojo.employee;

public class EmployeeManagerList {
    Long id;
    Long ManagerId;
    String firstName;
   String middelName;

   String lastName;


    public Long getManagerId() {
        return ManagerId;
    }

    public void setManagerId(Long managerId) {
        ManagerId = managerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddelName() {
        return middelName;
    }

    public void setMiddelName(String middelName) {
        this.middelName = middelName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
