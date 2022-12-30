package com.tool.smarthrbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.common.PaginationModel;
import com.tool.smarthrbackend.model.leave.LeaveApplication;
import com.tool.smarthrbackend.model.leave.LeaveBalance;
import com.tool.smarthrbackend.pojo.attendance.LeaveAttendanceResponse;
import com.tool.smarthrbackend.pojo.leave.LeaveForAttendance;
import com.tool.smarthrbackend.pojo.leave.LeaveStatusUpdate;
import com.tool.smarthrbackend.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smarthr/leave")
public class LeaveController {


    @Autowired
    LeaveService leaveService;

    //post request for leave application
    @PostMapping(path = "/submitLeaveApplication")
//	@CrossOrigin("http://localhost:3000")
    public ResponseEntity<?> submitLeaveApplication(@RequestBody LeaveApplication leaveApplication)
            throws JsonProcessingException {
        System.out.println("Inside  submitLeaveApplication");
        System.out.println(leaveApplication);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            leaveService.submitLeaveApplication(leaveApplication);
        } catch (Exception e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            errorMessage = e.toString();
        }
        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body("");
        }
    }

//  update   leave application
    @PutMapping (path = "/updateLeaveApplication")

    public ResponseEntity<?> updateLeaveApplication(@RequestBody LeaveApplication leaveApplication)
            throws JsonProcessingException {
        System.out.println(leaveApplication);
        String leaveUpdateStatu="";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
          leaveUpdateStatu=  leaveService.updateLeaveApplication(leaveApplication);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            errorMessage = e.toString();
        }
        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(leaveUpdateStatu);
        }
    }

//    delete leave application
    @DeleteMapping(path = "/deleteLeaveApplication")
    public ResponseEntity<?> deleteLeaveApplication(@RequestParam("leave_id") Long leaveId)
            throws JsonProcessingException {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");

        String errorMessage = "";
        String leaveDeleteStatus="";

        try {
           leaveDeleteStatus=  leaveService.deleteLeaveApplication(leaveId);
        } catch (Exception e) {

            errorMessage = e.toString();
        }

        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body("");
        }

    }


    @GetMapping(path = "/getAllLeaveTypes")
//    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<?> getAllLeaveTypes(@RequestParam("employee_id") Long employeeId)
            throws JsonProcessingException {
        System.out.println("Inside  getAllLeaveTypes");
        List<LeaveBalance> leaveTypeBalanceList = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            leaveTypeBalanceList = leaveService.getAllLeaveTypes(employeeId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            errorMessage = e.toString();
        }
        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(leaveTypeBalanceList);
        }
    }

//employee leave list by status  ,employee  leave summary
    @PostMapping(path = "/appliedEmployeeLeaveList")
//    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<?> getAppliedEmployeeLeaveList(@RequestParam("employee_id") Long employeeId,
                                                         @RequestParam(value = "status") String status,
                                                         @RequestBody PaginationModel paginationModel)
            throws JsonProcessingException {
        System.out.println("Inside  getDiscountedAmount");
        Page<LeaveApplication> availableEmployeeLeavesList = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            availableEmployeeLeavesList = leaveService.getAppliedLeaveApplications(employeeId,status,paginationModel);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            errorMessage = e.toString();
        }
        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(availableEmployeeLeavesList);
        }
    }


    @GetMapping(path = "/getAvailableEmployeeLeavesByEmployeeId")
//    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<?> getAvailableEmployeeLeaves(@RequestParam("employee_id") Long employeeId)
            throws JsonProcessingException {
        System.out.println("Inside  getAvailableEmployeeLeaves");
        List<LeaveBalance> availableEmployeeLeavesList = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            availableEmployeeLeavesList = leaveService.getAllLeaveBalanceByEmployeeId(employeeId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            errorMessage = e.toString();
        }
        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(availableEmployeeLeavesList);
        }
    }


//	leave list  by status and all leave list for manager

    @PostMapping(path = "/allEmployeeLeaveRequestList")
//    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<?> getAppliedEmployeeLeaveList(@RequestParam(value = "status", required = false) String status,
                                                         @RequestParam(value = "manager_id") Long managerId,
                                                         @RequestBody PaginationModel paginationModel)
            throws JsonProcessingException {
        System.out.println("Inside  getDiscountedAmount");
        Page<LeaveApplication> allEmployeeLeavesList = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            allEmployeeLeavesList = leaveService.getAllLeaveRequestApplications(status,managerId,paginationModel);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            errorMessage = e.toString();
        }
        if (!errorMessage.equalsIgnoreCase("")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(allEmployeeLeavesList);
        }
    }

    @PutMapping(value = "/leaveStatusUpdate")
    public ResponseEntity<?> updateLeaveStatus(@RequestBody LeaveStatusUpdate leaveStatusUpdate) throws
            JsonProcessingException{
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", "application/json");
        String errorMessage = "";
        try {
            leaveService.updateLeaveStatus(leaveStatusUpdate);
        } catch (Exception e) {
            errorMessage = e.toString();
        }
        if (errorMessage != "") {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body("");
        }


    }

    @PostMapping(value = "/allLeaveForAttendance")
    public List<LeaveForAttendance> getleaveList(@RequestBody LeaveAttendanceResponse leaveAttendanceResponse){
        List<LeaveForAttendance> leaveApplicationList=null;
        leaveApplicationList= leaveService.leave(leaveAttendanceResponse);
       return leaveApplicationList;
    }
}
