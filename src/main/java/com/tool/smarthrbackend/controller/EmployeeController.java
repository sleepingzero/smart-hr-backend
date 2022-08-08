package com.tool.smarthrbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import com.tool.smarthrbackend.model.leave.LeaveApplication;
import com.tool.smarthrbackend.model.leave.LeaveType;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeRequest;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeResponse;
import com.tool.smarthrbackend.pojo.employee.checkincheckout.EmployeeCheckInCheckOutRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginResponse;
import com.tool.smarthrbackend.service.EmployeeService;
import com.tool.smarthrbackend.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/smarthr/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //AddEmployeeRequest


    @GetMapping(path = "/getEmployeesById")
    public ResponseEntity<?> getEmployeesById(@RequestParam("employee_id") Long employeeId)
            throws JsonProcessingException {
        System.out.println("Inside  addEmplyeeRequest");

        HttpHeaders responseHeaders = new HttpHeaders();
        Employee employee = null;
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            employee = employeeService.getEmployeeById(employeeId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            errorMessage = e.toString();
        }
        if (errorMessage != "") {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(employee);
        }
    }


    @PostMapping(path = "/addEmplyeeRequest")
    public ResponseEntity<?> addEmplyeeRequest(@RequestBody AddEmployeeRequest addEmployeeRequest)
            throws JsonProcessingException {
        System.out.println("Inside  addEmplyeeRequest");

        HttpHeaders responseHeaders = new HttpHeaders();
        AddEmployeeResponse addEmployeeResponse = null;
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            addEmployeeResponse = employeeService.addEmployee(addEmployeeRequest);
            System.out.println("Sent response ===>" + addEmployeeResponse);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            errorMessage = e.toString();
        }
        if (errorMessage != "") {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(addEmployeeResponse);
        }
    }

    @GetMapping(path = "/getEmployeesBySearchTerm")
    public ResponseEntity<?> getEmployeesBySearchTerm(@RequestParam("search_term") String searchTerm)
            throws JsonProcessingException {
        System.out.println("Inside  addEmplyeeRequest");

        HttpHeaders responseHeaders = new HttpHeaders();
        List<Employee> employees = null;
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            employees = employeeService.getEmployeesBySearchTerm(searchTerm);
            System.out.println("Sent response ===>" + employees);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            errorMessage = e.toString();
        }
        if (errorMessage != "") {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(employees);
        }
    }


    @PostMapping(path = "/employeeLoginRequest")
    public ResponseEntity<?> employeeLoginRequest(@RequestBody EmployeeLoginRequest employeeLoginRequest)
            throws JsonProcessingException {
        System.out.println("Inside  addEmplyeeRequest");

        HttpHeaders responseHeaders = new HttpHeaders();
        EmployeeLoginResponse employeeLoginResponse = null;
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            employeeLoginResponse = employeeService.login(employeeLoginRequest);
            System.out.println("Sent response ===>" + employeeLoginResponse);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            errorMessage = e.toString();
        }
        if (errorMessage != "") {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(employeeLoginResponse);
        }
    }


    //employee checkin checkout  post mapping
    @PostMapping(path = "/employeeCheckInCheckOut")
    public void employeeCheckIn(@RequestBody EmployeeCheckInCheckOutRequest employeeCheckInCheckOutRequest)
            throws JsonProcessingException {
        String errormessage = "";
        try {
            employeeService.addCheckin(employeeCheckInCheckOutRequest);
        } catch (Exception e) {
            errormessage = e.toString();
            System.out.println(errormessage);

        }

    }

    @GetMapping(path = "/getEmployeeCheckInCheckOutAllById/{empid}")
    public List<EmployeeCheckInCheckOut> getEmployeesCheckInCheckOutId(@PathVariable("empid") Integer employeeId)
            throws JsonProcessingException, ParseException {
        List<EmployeeCheckInCheckOut> employeeCheckInCheckOuts;
        return employeeCheckInCheckOuts = employeeService.getEmployeeCheckInCheckOutAllById(employeeId);

    }

//    this is end point with date if date is null then it show according to current date
    @GetMapping(path = "/getEmployeeCheckInCheckOutByDate")
    public ResponseEntity<?> getEmployeeCheckInCheckOutByDate(@RequestParam(value = "date", required = false ) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                              @RequestParam("employeeId") Integer employeeId)
            throws JsonProcessingException, ParseException {
         System.out.println(date+" controller");

        List<EmployeeCheckInCheckOut> employeeCheckInCheckOuts = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            employeeCheckInCheckOuts = employeeService.getEmployeeCheckInCheckOutByDate(date, employeeId);
            System.out.println("get");
        } catch (Exception e) {
            errorMessage = e.toString();
            System.out.println(errorMessage);
        }
        if (errorMessage != "") {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().body(employeeCheckInCheckOuts);
        }
    }

    //    this is end point with  get current status
    @GetMapping(path = "/getEmployeeCheckInCheckOutstatus/{empid}")
    public ResponseEntity<?> getEmployeesCheckInCheckOutStatus(@PathVariable("empid") Integer employeeId)
            throws JsonProcessingException{
        EmployeeCheckInCheckOut employeeCheckInCheckOut=null;

        HttpHeaders responseHeaders= new HttpHeaders();
        responseHeaders.add("content-type","application/json");
        String errorMessage = "";

        try {
            employeeCheckInCheckOut=employeeService.getEmployeeCheckInCheckOutStatus(employeeId);
        }
        catch (Exception e){
            errorMessage=e.toString();
        }
        if(errorMessage !=""){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
        else {
            return  ResponseEntity.ok().body(employeeCheckInCheckOut);
        }



    }
}
