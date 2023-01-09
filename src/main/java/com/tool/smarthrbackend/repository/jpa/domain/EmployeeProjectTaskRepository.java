package com.tool.smarthrbackend.repository.jpa.domain;

import com.tool.smarthrbackend.model.domain.EmployeeProjectTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectTaskRepository extends JpaRepository<EmployeeProjectTask,Long> {
    List<EmployeeProjectTask> findTaskByEmployeeProjectId(Long projectId);

    Page<EmployeeProjectTask> findByTaskNameContaining(String searchTerm, Pageable pageable);
}
