package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeCheckInCheckOutRepository extends JpaRepository<EmployeeCheckInCheckOut,Long> {

     List<EmployeeCheckInCheckOut> findAllByEmployeeId(Integer employeeId) ;


}
