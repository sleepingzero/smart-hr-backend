package com.tool.smarthrbackend.pojo.employee;

import com.tool.smarthrbackend.model.metadata.Department;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AddEmployeeRequest {

    String name;
    String middleName;
    String personalEmailId;
    String professionalEmailId;
    String lastName;
    Long departmentId;
    Long employeeRoleId;
    Long designationId;
    Boolean isFirstTimeCreation;
    Long phoneNumber;
    List<Long> managerIds;
    List<Long> roles;


}
