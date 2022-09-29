package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeAddressRepository extends JpaRepository <EmployeeAddress ,Long> {

    EmployeeAddress findByempIdAndAddressType(Integer empId, Integer addressType);

}
