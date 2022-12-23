package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.common.PaginationForDomain;
import com.tool.smarthrbackend.model.common.PaginationModel;
import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.domain.EmployeeProject;
import com.tool.smarthrbackend.model.domain.EmployeeProjectTask;
import com.tool.smarthrbackend.repository.jpa.domain.DomainRepository;
import com.tool.smarthrbackend.repository.jpa.domain.EmployeeProjectRepository;
import com.tool.smarthrbackend.repository.jpa.domain.EmployeeProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<EmployeeProject> getAllProjectPagination(PaginationModel paginationModel) {
        String sortBy = paginationModel.getSortBy();

        Sort sort = paginationModel.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(paginationModel.getPageNo(), paginationModel.getPageSize(), sort);

        Page<EmployeeProject> employeeProjectPage=null;
        employeeProjectPage=employeeProjectRepository.findAll(pageable);
        return  employeeProjectPage;

    }

    public Page<EmployeeProjectTask> getAllTaskPagination(PaginationModel paginationModel) {
        String sortBy = paginationModel.getSortBy();

        Sort sort = paginationModel.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(paginationModel.getPageNo(), paginationModel.getPageSize(), sort);
        Page<EmployeeProjectTask> employeeProjectTaskPage=null;
        employeeProjectTaskPage=employeeProjectTaskRepository.findAll(pageable);
        return employeeProjectTaskPage;
    }

    public EmployeeProject getProjectById(Long projectId) {
        return  employeeProjectRepository.findById(projectId).get();
    }

    public EmployeeProjectTask getTaskById(Long taskId) {
        return  employeeProjectTaskRepository.findById(taskId).get();
    }

    public void deleteTaskById(Long taskId) {
        employeeProjectTaskRepository.deleteById(taskId);
    }

    public void deleteProjectById(Long projectId) {
        employeeProjectRepository.deleteById(projectId);
    }

    public void deleteDomainChildById(Long domainChildId) {
        domainRepository.deleteById(domainChildId);
    }

    public Page<Domain> findChildDomainsByDomainNameWithPagination(PaginationForDomain paginationForDomain) {
        String sortBy = paginationForDomain.getSortBy();

        Sort sort = paginationForDomain.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(paginationForDomain.getPageNo(), paginationForDomain.getPageSize(), sort);
        return  domainRepository.findChildDomainsByDomainName(paginationForDomain.getDomainName(),pageable);
    }
}
