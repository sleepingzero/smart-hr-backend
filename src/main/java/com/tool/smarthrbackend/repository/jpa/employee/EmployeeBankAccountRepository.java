package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeeBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeBankAccountRepository extends JpaRepository<EmployeeBankAccount,Long> {
}
