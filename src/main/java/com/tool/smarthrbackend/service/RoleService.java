package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.metadata.Role;
import com.tool.smarthrbackend.repository.jpa.metadata.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;


   public List<Role> findAllAvailableDepartments(){
        return  roleRepository.findAll();
    }








}
