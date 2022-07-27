package com.tool.smarthrbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.model.metadata.Role;
import com.tool.smarthrbackend.service.AttendanceShiftsService;
import com.tool.smarthrbackend.service.DepartmentService;
import com.tool.smarthrbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smarthr/metadata")
public class MetaDataController {


	@Autowired
	DepartmentService departmentService;


	@Autowired
	RoleService roleService;

	@Autowired
	AttendanceShiftsService attendanceShiftsService;


	@GetMapping(path = "/attendance/getAttendanceShifts")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<?> getAttendanceShifts()
			throws JsonProcessingException {
		System.out.println("Inside  attendanceShifts");
		List<AttendanceShifts> attendanceShifts = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			attendanceShifts = attendanceShiftsService.findAllAttendanceShifts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(attendanceShifts);
		}
	}

	@GetMapping(path = "/department/getAllDepartments")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<?> getDomainByDomainName()
			throws JsonProcessingException {
		System.out.println("Inside  publicHolidays");
		List<Department> departments = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			departments = departmentService.findAllAvailableDepartments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(departments);
		}
	}

	@GetMapping(path = "/role/getAllRoles")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<?> getAllRoles()
			throws JsonProcessingException {
		System.out.println("Inside  getAllRoles");
		List<Role> roles = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			roles = roleService.findAllAvailableDepartments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(roles);
		}
	}


}
