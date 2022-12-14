package com.tool.smarthrbackend.repository.jpa.leave;

import com.tool.smarthrbackend.model.leave.LeaveApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface LeaveApplicationRepository extends CrudRepository<LeaveApplication, Long> {
    Optional<LeaveApplication> findById(Long id);
    Page<LeaveApplication> findByEmpIdAndLeaveStatusOrderByCreatedDateDescIdDesc(Long id,String status,Pageable pageable);


    Page<LeaveApplication> findByLeaveStatusAndEmpManagerId(String status, Long managerId, Pageable pageable);

    List<LeaveApplication>findAll();

    List<LeaveApplication> findByEmpManagerId(Long managerId);

    Page<LeaveApplication> findAll(Pageable pageable);

//   @Query( "SELECT l FROM LeaveApplication l WHERE  l."),
//    SELECT * FROM main.employee_leave_application
//    where employee_id=10 and from_date <= '2022-12-17' And to_date >= '2022-12-17';


List<LeaveApplication> findByEmpIdAndFromDateLessThanEqualAndToDateGreaterThanEqual(Long id, Date date1, Date date2);

}