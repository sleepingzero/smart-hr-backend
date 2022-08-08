package com.tool.smarthrbackend.repository.jpa.domain;

import com.tool.smarthrbackend.model.domain.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject,Long> {
}
