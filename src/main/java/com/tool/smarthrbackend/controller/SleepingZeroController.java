package com.tool.smarthrbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tool.smarthrbackend.model.sleepingZero.ContactUs;
import com.tool.smarthrbackend.service.SleepingZeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sleepingzero")
public class SleepingZeroController {

    @Autowired
    SleepingZeroService sleepingZeroService;

//    endpoint for contact us in sleepingZero website
    @PostMapping(path="/contactUs")
    public ResponseEntity<?> addContactUsData(@RequestBody ContactUs contactUs)
    throws JsonProcessingException {

        ContactUs contactUs1=null;
        HttpHeaders responseheaders=new HttpHeaders();
        responseheaders.add("content-Type","application/json");
        String successMessage="thank you we will get back to you in short time";
        String errorMessage="";
        try{
           contactUs1=  sleepingZeroService.addContactUs(contactUs);
        }
        catch (Exception e){
            errorMessage=e.toString();
        }
        if (errorMessage != "")
        {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }    else {
            return ResponseEntity.ok(successMessage);
        }
    }
//    list to add multiple objects in sql database
//    List<ContactUs> contact2=null;
//    @PostMapping(path="/contactUs2")
//
//    public List<ContactUs> addContactUsData2(@RequestBody List<ContactUs> contact2)
//            throws JsonProcessingException {
//
//        HttpHeaders responseheaders=new HttpHeaders();
//        responseheaders.add("content-Type","application/json");
//        String successMessage="thank you we will get back to you in short time";
//        String errorMessage="";
//        return contact2 = sleepingZeroService.addContactUs2(contact2);
//
//    }
}
