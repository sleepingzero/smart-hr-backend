package com.tool.smarthrbackend.repository.jpa.domain;

import com.tool.smarthrbackend.model.domain.EmployeeTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask,Long> {
    List<EmployeeTask> findTaskByEmployeeProjectId(Long projectId);
}
