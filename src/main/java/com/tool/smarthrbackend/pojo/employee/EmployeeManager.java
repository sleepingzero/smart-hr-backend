package com.tool.smarthrbackend.pojo.employee;

import com.tool.smarthrbackend.model.employee.Employee;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeManager {

    Employee employee;
    Employee manager;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
