package com.tool.smarthrbackend.pojo.login;

import com.tool.smarthrbackend.model.employee.Employee;
import lombok.Data;

@Data
public class EmployeeLoginResponse {

    Boolean isError = false;
    Employee employee ;
    String errorMsg ;

}
