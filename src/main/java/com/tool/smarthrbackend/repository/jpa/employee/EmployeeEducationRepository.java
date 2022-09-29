package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation , Long> {
}
