package com.tool.smarthrbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.holiday.PublicHoliday;
import com.tool.smarthrbackend.service.DomainService;
import com.tool.smarthrbackend.service.HolidayService;
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
		System.out.println("Inside  publicHolidays");
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

}