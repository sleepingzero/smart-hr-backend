package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.repository.jpa.metadata.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


   public List<Department> findAllAvailableDepartments(){
        return  departmentRepository.findAll();
    }








}
