package com.tool.smarthrbackend.repository.jpa.employee;


import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.employee.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findById(Long id);

    Optional<Employee> findByPersonalEmailId(String personalEmailId);

    Optional<Employee> findByProfessionalEmailId(String professionalEmailId);

    @Query("select e FROM Employee e where lower(e.firstName) like '%?1%'  or lower(e.middleName) like '%?1%' or lower(e.lastName) like '%?1%'")
    List<Employee> findEmployeeBySearchString(String searchString);

    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String searchString,String searchString2);

    @Override
    List<Employee> findAll();

    List<Employee>findAllByManagerId(Long managerId);


}