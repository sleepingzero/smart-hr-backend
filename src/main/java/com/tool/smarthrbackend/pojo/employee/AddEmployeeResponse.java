package com.tool.smarthrbackend.pojo.employee;

import lombok.Data;
import lombok.ToString;


    @Data
@ToString
public class AddEmployeeResponse {

    Long generatedEmpId;
    Long generatedTmpOtp;
    String returnMsg;


}
