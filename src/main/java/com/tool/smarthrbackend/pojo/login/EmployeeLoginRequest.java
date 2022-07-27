package com.tool.smarthrbackend.pojo.login;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class EmployeeLoginRequest {

    @NotNull
    Boolean isOTP;
    @NotNull
    String username;

    @NotNull
    String password;

    Long otp;

}
