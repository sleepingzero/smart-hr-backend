package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.common.PaginationModel;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


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

        return leaveBalanceRepository.findByEmployeeId(employeeId);
    }

    public List<LeaveBalance> getAllLeaveBalanceByEmployeeId(Long employeeId) throws Exception {
        return leaveBalanceRepository.findByEmployeeId(employeeId);
    }

//    public List<LeaveApplication> getAppliedLeaveApplications(Long employeeId, String status) throws Exception {
//        return leaveApplicationRepository.
//                findByEmpIdAndLeaveStatusOrderByCreatedDateDescIdDesc(employeeId, status);
//    }


    //    LEAVE LIST WITH PAGINATION
    public Page<LeaveApplication> getAppliedLeaveApplications(Long employeeId,
                                                              String status, PaginationModel paginationModel) throws Exception {
        String sortBy = paginationModel.getSortBy();

        Sort sort = paginationModel.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(paginationModel.getPageNo() , paginationModel.getPageSize(), sort);

        return leaveApplicationRepository.findByEmpIdAndLeaveStatusOrderByCreatedDateDescIdDesc
                (employeeId, status, pageable);
    }

    public void submitLeaveApplication(LeaveApplication leaveApplication) {
        System.out.println(leaveApplication.toString());
        leaveApplication.setCreatedDate(new Date());
        leaveApplication.setUpdatedDate(new Date());

//		 Employee employee = employeeRepository.findById(leaveApplication.getEmployeeId()).get();
        Employee employee;
        employee = employeeRepository.findById(leaveApplication.getEmployeeId()).get();
        leaveApplication.setApprovedById(employee.getManagerId());

        leaveApplication.setEmp(employee);
        LeaveType leaveType = leaveTypeRepository.findById(leaveApplication.getLeaveTypeId()).get();
        leaveApplication.setLeaveType(leaveType);
        if (leaveApplication.getLeaveStatus() == null)
            leaveApplication.setLeaveStatus("Pending");
        leaveApplicationRepository.save(leaveApplication);
    }

    public String updateLeaveApplication(LeaveApplication leaveApplication) {
        LeaveApplication exitstingLeaveApplication = new LeaveApplication();

//		check particular data is present in datbase???
        boolean isExist = leaveApplicationRepository.findById(leaveApplication.getId()).isPresent();

        if (isExist == true) {
            System.out.println("application " + isExist);
            exitstingLeaveApplication = leaveApplicationRepository.findById(leaveApplication.getId()).get();
            exitstingLeaveApplication.setUpdatedDate(new Date());
            exitstingLeaveApplication.setFromDate(leaveApplication.getFromDate());
            exitstingLeaveApplication.setToDate(leaveApplication.getToDate());
            exitstingLeaveApplication.setFromDateHalf(leaveApplication.getFromDateHalf());
            exitstingLeaveApplication.setToDateHalf(leaveApplication.getToDateHalf());
            exitstingLeaveApplication.setLeaveTypeId(leaveApplication.getLeaveTypeId());
            exitstingLeaveApplication.setLeaveReason(leaveApplication.getLeaveReason());
            exitstingLeaveApplication.setTotalLeaveDays(leaveApplication.getTotalLeaveDays());
            leaveApplicationRepository.save(exitstingLeaveApplication);
            return "successfull update";
        } else {
            return "your leave application not found";
        }

    }

    public String deleteLeaveApplication(Long leaveId) {
        boolean isExist = leaveApplicationRepository.findById(leaveId).isPresent();
        String returnStatment = "";
        if (isExist == true) {
            leaveApplicationRepository.deleteById(leaveId);
            if (leaveApplicationRepository.findById(leaveId).isPresent() == false) {
                returnStatment = "successfully deleted";
            }
        } else {
            returnStatment = "your leave application not found";
        }
        return returnStatment;
    }


    public List<Map<String, Object>> getAvailableLeavesByEmployeeId(Long employeeId) {
        //return  leaveRepository.getAvailableLeavesByEmployeeId(employeeId);
        return null;
    }


//    public List<LeaveApplication> getAllLeaveApplications(String status, Long managerId) {
//        if (status == null) {
//            return leaveApplicationRepository.findByEmpManagerId(managerId);
//        } else {
//            return leaveApplicationRepository.findByLeaveStatusAndEmpManagerId(status, managerId, pageable);
//        }
//    }


    public Page<LeaveApplication> getAllLeaveRequestApplications
            (String status, Long managerId, PaginationModel paginationModel) {
        String sortBy = paginationModel.getSortBy();

        Sort sort = paginationModel.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(paginationModel.getPageNo(), paginationModel.getPageSize(), sort);
        return leaveApplicationRepository.findByLeaveStatusAndEmpManagerId(status, managerId, pageable);
    }

    public void updateLeaveStatus(LeaveStatusUpdate leaveStatusUpdate) {
        String statusChange = leaveStatusUpdate.getStatus();
        Long approvedBy = leaveStatusUpdate.getApprovedById();

        System.out.println(leaveStatusUpdate.getIdList() + "serviceee ");
//			existingEmployeeEducation= employeeEducationRepository.findById(eduction.getId()).get(
        leaveStatusUpdate.getIdList().forEach(Id -> {
            LeaveApplication leaveApplication = null;

            leaveApplication = leaveApplicationRepository.findById(Id).get();

            leaveApplication.setLeaveStatus(statusChange);
            leaveApplication.setApprovedById(approvedBy);
            leaveApplication.setUpdatedDate(new Date());
            System.out.println(leaveApplication);
            LeaveBalance leaveBalance = null;
            System.out.println(statusChange);
//	if status changes to approved than deduct total leave days from avalaibale balance
            if (Objects.equals(statusChange, "approved")) {


                leaveBalance = leaveBalanceRepository.findByEmployeeIdAndLeaveTypeId(leaveApplication.getEmp().getId(),
                        leaveApplication.getLeaveType().getId());
                double leaveBalanceUpdate = leaveBalance.getLeaveBalance() - leaveApplication.getTotalLeaveDays();
                leaveBalance.setLeaveBalance(leaveBalanceUpdate);
                leaveBalance.setUpdatedDate(new Date());
                leaveBalance.setLastLeaveAppId(leaveApplication.getId());
                System.out.println("llllllllllllllllllllllll" + leaveBalance);
                leaveBalanceRepository.save(leaveBalance);
            }
            leaveApplicationRepository.save(leaveApplication);

        });

    }

// Pagination sorting
//    public Page<LeaveApplication> getleaveList(PaginationModel paginationModel) {
//        String sortBy = paginationModel.getSortBy();
//
//        Sort sort = paginationModel.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
//                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//
//        Pageable pageable = PageRequest.of(paginationModel.getPageNo() - 1, paginationModel.getPageSize(), sort);
//        return leaveApplicationRepository.findAll(pageable);
//    }

    public List<LeaveApplication> leave(List<Integer> getEmpList, LocalDate todatte, LocalDate fromdate){
        List<LeaveApplication> leaveApplicationList=new ArrayList<>();
   leaveApplicationList= leaveApplicationRepository.findAllByIdAndFromDateLessThanEqualAndToDateGreaterThanEqual(10,todatte,fromdate);

      return   leaveApplicationList;
    }
}
