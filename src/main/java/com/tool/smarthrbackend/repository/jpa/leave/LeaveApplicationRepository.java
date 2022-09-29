package com.tool.smarthrbackend.repository.jpa.leave;

import com.tool.smarthrbackend.model.leave.LeaveApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LeaveApplicationRepository extends CrudRepository<LeaveApplication, Long> {
    Optional<LeaveApplication> findById(Long id);
    List<LeaveApplication> findByEmpIdOrderByCreatedDateDesc(Long id);


    List<LeaveApplication> findByLeaveStatus(String status);
    List<LeaveApplication>findAll();

}