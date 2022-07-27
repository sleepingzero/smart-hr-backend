package com.tool.smarthrbackend.repository.jpa.leave;


import com.tool.smarthrbackend.model.leave.LeaveType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveTypeRepository extends CrudRepository<LeaveType, Long> {
    Optional<LeaveType> findById(Long id);

    @Override
    List<LeaveType> findAll();
}