package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.leave.LeaveApplication;
import com.tool.smarthrbackend.model.leave.LeaveBalance;
import com.tool.smarthrbackend.model.leave.LeaveType;
import com.tool.smarthrbackend.repository.jpa.employee.EmployeeRepository;
import com.tool.smarthrbackend.repository.jpa.leave.LeaveApplicationRepository;
import com.tool.smarthrbackend.repository.jpa.leave.LeaveBalanceRepository;
import com.tool.smarthrbackend.repository.jpa.leave.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class LeaveService {

	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Autowired
	LeaveBalanceRepository leaveBalanceRepository;

	@Autowired
	LeaveApplicationRepository leaveApplicationRepository;

	@Autowired
	EmployeeRepository employeeRepository;


	public List<LeaveType> getAllLeaveTypes() throws Exception {
      return  leaveTypeRepository.findAll();
	}

	public  List<LeaveBalance> getAllLeaveBalanceByEmployeeId(Long employeeId) throws Exception{
		return  leaveBalanceRepository.findByEmployeeId(employeeId);
	}
	public  List<LeaveApplication> getAppliedLeaveApplications(Long employeeId) throws Exception{
		return  leaveApplicationRepository.findByEmpIdOrderByCreatedDateDesc(employeeId);
	}

	public  void submitLeaveApplication(LeaveApplication leaveApplication){
		System.out.println(leaveApplication.toString());
		leaveApplication.setCreatedDate(new Date());
		leaveApplication.setUpdatedDate(new Date());
		 Employee employee = employeeRepository.findById(leaveApplication.getEmployeeId()).get();
		 leaveApplication.setEmp(employee);
          LeaveType leaveType = leaveTypeRepository.findById(leaveApplication.getLeaveTypeId()).get();
		 leaveApplication.setLeaveType(leaveType);
		if(leaveApplication.getLeaveStatus()==null)
			leaveApplication.setLeaveStatus("Pending");
		leaveApplicationRepository.save(leaveApplication);
	}


	public List<Map<String,Object>> getAvailableLeavesByEmployeeId(Long employeeId){
		//return  leaveRepository.getAvailableLeavesByEmployeeId(employeeId);
	 return  null;
	}



}
