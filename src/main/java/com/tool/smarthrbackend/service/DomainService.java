package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.domain.EmployeeProject;
import com.tool.smarthrbackend.model.domain.EmployeeProjectTask;
import com.tool.smarthrbackend.repository.jpa.domain.DomainRepository;
import com.tool.smarthrbackend.repository.jpa.domain.EmployeeProjectRepository;
import com.tool.smarthrbackend.repository.jpa.domain.EmployeeProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DomainService {

    @Autowired
    DomainRepository domainRepository;

   @Autowired
    EmployeeProjectRepository employeeProjectRepository;

   @Autowired
   EmployeeProjectTaskRepository employeeProjectTaskRepository;

    public List<Domain> findChildDomainsByDomainName(String domainName){
        return  domainRepository.findChildDomainsByDomainName(domainName);
    }


    public Domain getDomainByDomainName(String domainName){
        return  domainRepository.findByDomainName(domainName);
    }

    public void saveDomain(Domain domain){
          domain.setCreatedDate(new Date());
          domain.setUpdatedDate(new Date());
          domainRepository.save(domain);
    }

//for list of all project
    public List<EmployeeProject> getAllProject() {
        return employeeProjectRepository.findAll();
    }

// for list of all task by project id
    public List<EmployeeProjectTask> getTaskByProjectId(Long projectId) {
        return employeeProjectTaskRepository.findTaskByEmployeeProjectId(projectId);
    }

    public EmployeeProject saveProject(EmployeeProject employeeProject) {

        return employeeProjectRepository.save(employeeProject);
    }

    public EmployeeProjectTask saveTask(EmployeeProjectTask employeeProjectTask) {
        return employeeProjectTaskRepository.save(employeeProjectTask);
    }
}
