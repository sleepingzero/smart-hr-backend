package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeePfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePfAccountRepository extends JpaRepository<EmployeePfAccount,Long> {
}
