package com.tool.smarthrbackend.repository.jpa.employee;


import com.tool.smarthrbackend.model.employee.EmployeeRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRoleRepository extends CrudRepository<EmployeeRole, Long> {
    Optional<EmployeeRole> findById(Long id);

    @Override
    List<EmployeeRole> findAll();
}