package com.tool.smarthrbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.domain.EmployeeProject;
import com.tool.smarthrbackend.model.domain.EmployeeProjectTask;
import com.tool.smarthrbackend.repository.jpa.domain.EmployeeProjectRepository;
import com.tool.smarthrbackend.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smarthr/domain")
public class DomainController {


	@Autowired
	DomainService domainService;
   @Autowired
	EmployeeProjectRepository employeeProjectRepository;


	@GetMapping(path = "/getDomainByDomainName")
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<?> getDomainByDomainName(@RequestParam("domain_name") String domainName)
			throws JsonProcessingException {
		System.out.println("Inside  publicHolidays");
		Domain domain = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			domain = domainService.getDomainByDomainName(domainName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(domain);
		}
	}


		@GetMapping(path = "/getChildDomainsByDomainName")
		@CrossOrigin("http://localhost:4200")
	public ResponseEntity<?> getPublicHolidaysByYear(@RequestParam("domain_name") String domainName)
			throws JsonProcessingException {
		System.out.println("Inside  publicHolidays");
		List<Domain> domains = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			domains = domainService.findChildDomainsByDomainName(domainName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(domains);
		}
	}

	@PostMapping(path = "/saveDomain")
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<?> saveDomain(@RequestBody  Domain domain)
			throws JsonProcessingException {
		System.out.println("Inside  publicHolidays"+domain);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			 domainService.saveDomain(domain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body("success");
		}
	}
//endpoint	for get list of all project with project_id
    @GetMapping(path = "/getAllProjects")
	public ResponseEntity<?> getAllProject()
			throws  JsonProcessingException{

		HttpHeaders responseHeaders= new HttpHeaders();
		List<EmployeeProject> employeeProject=null;
		responseHeaders.add("content-type","application/json");
        String errorMessage="";

		try {
			employeeProject= domainService.getAllProject();
		}
		catch (Exception e){
			errorMessage=e.toString();
		}
		if (errorMessage !=""){
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);

		}
		else {
			return  ResponseEntity.ok().headers(responseHeaders).body(employeeProject);
		}
	}

// end point for get list of task by project_id

	@GetMapping(path = "/getTasksByProjectId")
	public ResponseEntity<?> getTaskByProjectId(@RequestParam(value = "projectId") Long projectId)
			throws  JsonProcessingException{

		HttpHeaders responseHeaders= new HttpHeaders();
		List<EmployeeProjectTask> employeeProjectTasks =null;
		responseHeaders.add("content-type","application/json");
		String errorMessage="";

		try {
			employeeProjectTasks = domainService.getTaskByProjectId(projectId);
		}
		catch (Exception e){
			errorMessage=e.toString();
		}
		if (errorMessage !=""){
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);

		}
		else {
			return  ResponseEntity.ok().headers(responseHeaders).body(employeeProjectTasks);
		}
	}

	@PutMapping (path="/addProject")
	public ResponseEntity<?> addNewProject(@RequestBody EmployeeProject employeeProject){
		EmployeeProject employeeProject1= null;
		 HttpHeaders responseHeaders= new HttpHeaders();
		 responseHeaders.add("content-type","application/json");
		 String errorMessage="";
		 try{
			 employeeProject1= domainService.saveProject(employeeProject);
		 }
		 catch (Exception e){
			 errorMessage=e.toString();
		 }
		 if (!errorMessage.equalsIgnoreCase("")){
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		 } else {
			 return  ResponseEntity.ok().headers(responseHeaders).body("success".toString()+employeeProject1);
		 }
	}

	@PutMapping (path="/addProjectTask")
	public ResponseEntity<?> addNewProjectTask(@RequestBody EmployeeProjectTask employeeProjectTask){
		EmployeeProjectTask employeeProjectTask1= null;
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.add("content-type","application/json");
		String errorMessage="";
		try{
			employeeProjectTask1= domainService.saveTask(employeeProjectTask);
		}
		catch (Exception e){
			errorMessage=e.toString();
		}
		if (!errorMessage.equalsIgnoreCase("")){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return  ResponseEntity.ok().headers(responseHeaders).body("success".toString()+employeeProjectTask1);
		}
	}
}
