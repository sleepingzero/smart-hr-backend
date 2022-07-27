package com.tool.smarthrbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.leave.LeaveApplication;
import com.tool.smarthrbackend.model.leave.LeaveBalance;
import com.tool.smarthrbackend.model.leave.LeaveType;
import com.tool.smarthrbackend.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/smarthr/leave")
public class LeaveController {


	@Autowired
	LeaveService leaveService;

	@PostMapping(path = "/submitLeaveApplication")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<?> submitLeaveApplication(@RequestBody LeaveApplication leaveApplication)
			throws JsonProcessingException {
		System.out.println("Inside  submitLeaveApplication");
		System.out.println(leaveApplication);
		Double discountedAmount = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			leaveService.submitLeaveApplication(leaveApplication);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body("Success");
		}
	}
	@GetMapping(path = "/getAllLeaveTypes")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<?> getAllLeaveTypes()
			throws JsonProcessingException {
		System.out.println("Inside  getAllLeaveTypes");
		List<LeaveType> leaveTypeList = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
		leaveTypeList = leaveService.getAllLeaveTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(leaveTypeList);
		}
	}

	@GetMapping(path = "/appliedEmployeeLeaveList")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<?> getAppliedEmployeeLeaveList(@RequestParam("employee_id") Long employeeId)
			throws JsonProcessingException {
		System.out.println("Inside  getDiscountedAmount");
		List<LeaveApplication> availableEmployeeLeavesList = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			availableEmployeeLeavesList = leaveService.getAppliedLeaveApplications(employeeId);
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
	@CrossOrigin("http://localhost:3000")
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

}
