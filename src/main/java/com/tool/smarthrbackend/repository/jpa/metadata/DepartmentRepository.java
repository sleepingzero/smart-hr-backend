package com.tool.smarthrbackend.repository.jpa.metadata;


import com.tool.smarthrbackend.model.metadata.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Optional<Department> findById(Long id);

    @Override
    List<Department> findAll();

}