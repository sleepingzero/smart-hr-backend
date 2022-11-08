package com.tool.smarthrbackend.repository.jpa.leave;


import com.tool.smarthrbackend.model.leave.LeaveBalance;
import com.tool.smarthrbackend.model.leave.LeaveType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends CrudRepository<LeaveBalance, Long> {
    Optional<LeaveBalance> findById(Long id);

   List<LeaveBalance>  findByEmployeeId(Long id);
    @Override
    List<LeaveBalance> findAll();

    LeaveBalance findByEmployeeIdAndLeaveTypeId(long empId, long leaveId);
}