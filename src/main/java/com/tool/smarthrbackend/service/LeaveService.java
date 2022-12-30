package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.common.PaginationModel;
import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.leave.LeaveApplication;
import com.tool.smarthrbackend.model.leave.LeaveBalance;
import com.tool.smarthrbackend.model.leave.LeaveType;

import com.tool.smarthrbackend.pojo.attendance.LeaveAttendanceResponse;
import com.tool.smarthrbackend.pojo.leave.LeaveForAttendance;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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


//    public List<LeaveApplication> getAllLeaveApplications(String status, Long managerId) {
//        if (status == null) {
//            return leaveApplicationRepository.findByEmpManagerId(managerId);
//        } else {
//            return leaveApplicationRepository.findByLeaveStatusAndEmpManagerId(status, managerId, pageable);
//        }
//    }

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

    public List<LeaveForAttendance> leave(LeaveAttendanceResponse leaveAttendanceResponse) {
        List<LeaveApplication> leaveApplicationList = new ArrayList<>();
      List<LeaveForAttendance> leaveForAttendanceList=new ArrayList<>();
        List<LocalDate> LocalDatelis= getDatesBetweenUsingJava8(leaveAttendanceResponse.getFromDate(), leaveAttendanceResponse.getToDate());
        System.out.println(LocalDatelis);
        leaveAttendanceResponse.getEmpIdList().forEach(empid->{


        LocalDatelis.forEach(localDate -> {
            LeaveForAttendance leaveForAttendance=new LeaveForAttendance();
            List<LeaveApplication> applicationList=new ArrayList<>();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("jdskhdddddd7erewyreuriwei" +date);

//            LeaveApplication leaveApplication=new LeaveApplication();
                    applicationList=       leaveApplicationRepository.findByEmpIdAndFromDateLessThanEqualAndToDateGreaterThanEqual(empid,date,date);

          applicationList.forEach(leaveApplication->{

              if (leaveApplication == null){

              }
              else {
                  leaveForAttendance.setLeaveId(leaveApplication.getId());
                  Calendar cal = Calendar.getInstance();
                  cal.setTime(date);
                  cal.add(Calendar.DATE, 1);
                  Date toDate = cal.getTime();
                  leaveForAttendance.setDate(toDate);
                  leaveForAttendance.setEmpId(leaveApplication.getEmp().getId());

                  java.util.Date dt = date;

                  java.text.SimpleDateFormat sdf =
                          new java.text.SimpleDateFormat("yyyy-MM-dd");

                  String currentTime = sdf.format(date);
                  String leavefromDtae=sdf.format(leaveApplication.getFromDate());
                  String leaveToDate = sdf.format(leaveApplication.getToDate());
                  System.out.println(currentTime+leavefromDtae+"488888888888888888888888888888888888888888888888888888887");

                  if (leavefromDtae.equals(leaveToDate)) {
                      if (leaveApplication.getToDateHalf()==1 && leaveApplication.getFromDateHalf()==1){
                          leaveForAttendance.setLeaveStatus("first half");
                      }
                      else if (leaveApplication.getToDateHalf()==2 && leaveApplication.getFromDateHalf()==2){
                          leaveForAttendance.setLeaveStatus("second half");
                      }
                      else {
                          leaveForAttendance.setLeaveStatus("full day leave");
                      }

                  }
                  else if(currentTime.equals(leavefromDtae) && leaveApplication.getFromDateHalf()==2){
                      leaveForAttendance.setLeaveStatus("second half");
                  }
                  else if (currentTime.equals(leaveToDate) && leaveApplication.getToDateHalf()==1) {
                      leaveForAttendance.setLeaveStatus("first half");
                  } else {
                      leaveForAttendance.setLeaveStatus(" full day leave");
                  }
                  leaveForAttendanceList.add(leaveForAttendance);
              }
          });

        });
        });
        System.out.println("57777777777777777777777777777"+leaveForAttendanceList);
//        LeaveApplication leaveApplication=leaveApplicationRepository.findByEmpIdAndFromDateLessThanAndToDateGreaterThanEqual(10L,leaveaa.getFromDate(),leaveaa.getToDate());
//        System.out.println(leaveApplication);

       return leaveForAttendanceList;
    }

//    public static List<Date> getDaysBetweenDates(Date startdate, Date enddate) {
//        List<Date> dates = new ArrayList<Date>();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(startdate);
//
//        while (calendar.getTime().before(enddate)) {
//            Date result = calendar.getTime();
//            dates.add(result);
//            calendar.add(Calendar.DATE, 1);
//        }
//        return dates;
//    }

    public static List<LocalDate> getDatesBetweenUsingJava8(
             LocalDate endDate, LocalDate startDate ) {
        LocalDate start = startDate;
        LocalDate end = endDate;
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        System.out.println("ddddddddddddddddaaaaaaaaa" + totalDates);
        return totalDates;
    }

//    public List<LeaveApplication> getAppliedLeaveApplications(Long employeeId, String status) throws Exception {
//        return leaveApplicationRepository.
//                findByEmpIdAndLeaveStatusOrderByCreatedDateDescIdDesc(employeeId, status);
//    }

}
