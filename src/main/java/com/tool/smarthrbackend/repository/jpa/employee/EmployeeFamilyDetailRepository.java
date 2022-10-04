package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeeFamilyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFamilyDetailRepository extends JpaRepository<EmployeeFamilyDetail,Long> {

}
