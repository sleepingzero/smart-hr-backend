package com.tool.smarthrbackend.repository.jpa.leave;

import com.tool.smarthrbackend.model.leave.LeaveApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LeaveApplicationRepository extends CrudRepository<LeaveApplication, Long> {
    Optional<LeaveApplication> findById(Long id);
    List<LeaveApplication> findByEmpIdAndLeaveStatusOrderByCreatedDateDesc(Long id,String status);


    List<LeaveApplication> findByLeaveStatusAndEmpManagerId(String status,Long managerId);

    List<LeaveApplication>findAll();

    List<LeaveApplication> findByEmpManagerId(Long managerId);

}