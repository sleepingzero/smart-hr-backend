package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.leave.LeaveApplication;
import com.tool.smarthrbackend.model.leave.LeaveBalance;
import com.tool.smarthrbackend.model.leave.LeaveType;
import com.tool.smarthrbackend.pojo.leave.LeaveStatusUpdate;
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


	public List<LeaveBalance> getAllLeaveTypes(Long employeeId) throws Exception {

      return  leaveBalanceRepository.findByEmployeeId(employeeId);
	}

	public  List<LeaveBalance> getAllLeaveBalanceByEmployeeId(Long employeeId) throws Exception{
		return  leaveBalanceRepository.findByEmployeeId(employeeId);
	}
	public  List<LeaveApplication> getAppliedLeaveApplications(Long employeeId, String status) throws Exception{
		return  leaveApplicationRepository.findByEmpIdAndLeaveStatusOrderByCreatedDateDescIdDesc(employeeId,status);
	}

	public  void submitLeaveApplication(LeaveApplication leaveApplication){
		System.out.println(leaveApplication.toString());
		leaveApplication.setCreatedDate(new Date());
		leaveApplication.setUpdatedDate(new Date());
//		 Employee employee = employeeRepository.findById(leaveApplication.getEmployeeId()).get();
		Employee employee;
		employee= employeeRepository.findById(leaveApplication.getEmployeeId()).get();
		leaveApplication.setApprovedById(employee.getManagerId());

		 leaveApplication.setEmp(employee);
          LeaveType leaveType = leaveTypeRepository.findById(leaveApplication.getLeaveTypeId()).get();
		 leaveApplication.setLeaveType(leaveType);
		if(leaveApplication.getLeaveStatus()==null)
			leaveApplication.setLeaveStatus("Pending");
		leaveApplicationRepository.save(leaveApplication);
	}
	public String updateLeaveApplication(LeaveApplication leaveApplication)  {
		LeaveApplication exitstingLeaveApplication= new LeaveApplication();

//		check particular data is present in datbase???
		boolean isExist=leaveApplicationRepository.findById(leaveApplication.getId()).isPresent();

		if (isExist== true){
			System.out.println("application " +isExist);
			exitstingLeaveApplication=leaveApplicationRepository.findById(leaveApplication.getId()).get();
             exitstingLeaveApplication.setUpdatedDate(new Date());
			 exitstingLeaveApplication.setFromDate(leaveApplication.getFromDate());
			 exitstingLeaveApplication.setToDate(leaveApplication.getToDate());
			 exitstingLeaveApplication.setFromDateHalf(leaveApplication.getFromDateHalf());
			 exitstingLeaveApplication.setToDateHalf(leaveApplication.getToDateHalf());
			 exitstingLeaveApplication.setLeaveTypeId(leaveApplication.getLeaveTypeId());
			 exitstingLeaveApplication.setLeaveReason(leaveApplication.getLeaveReason());
             exitstingLeaveApplication.setTotalLeaveDays(leaveApplication.getTotalLeaveDays());
			 leaveApplicationRepository.save(exitstingLeaveApplication);
			 return  "successfull update";
		}
		else {
			return "your leave application not found";
		}

	}
	public String deleteLeaveApplication(Long leaveId) {
		boolean isExist= leaveApplicationRepository.findById(leaveId).isPresent();
		String returnStatment="";
		if (isExist== true){
			leaveApplicationRepository.deleteById(leaveId);
			if (leaveApplicationRepository.findById(leaveId).isPresent()== false){
				returnStatment= "successfully deleted";
			}
		}
		else {
			returnStatment= "your leave application not found";
		}
         return returnStatment;
	}


	public List<Map<String,Object>> getAvailableLeavesByEmployeeId(Long employeeId){
		//return  leaveRepository.getAvailableLeavesByEmployeeId(employeeId);
	 return  null;
	}


    public List<LeaveApplication> getAllLeaveApplications(String status, Long managerId) {
		if (status==null){
       return leaveApplicationRepository.findByEmpManagerId(managerId);
		}
		else {
		return leaveApplicationRepository.findByLeaveStatusAndEmpManagerId(status,managerId);
    }
	}

	public void updateLeaveStatus(LeaveStatusUpdate leaveStatusUpdate) {
           String  statusChange=leaveStatusUpdate.getStatus();
		   Long approvedBy=leaveStatusUpdate.getApprovedById();

			System.out.println(leaveStatusUpdate.getIdList() +"serviceee ");
//			existingEmployeeEducation= employeeEducationRepository.findById(eduction.getId()).get(
			leaveStatusUpdate.getIdList().forEach(Id->{
				LeaveApplication leaveApplication= null;
				leaveApplication= leaveApplicationRepository.findById(Id).get();
				leaveApplication.setLeaveStatus(statusChange);
				leaveApplication.setApprovedById(approvedBy);
				System.out.println(leaveApplication);
				leaveApplicationRepository.save(leaveApplication);

			});

	}



}
