package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.attendance.Attendance;
import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import com.tool.smarthrbackend.model.holiday.PublicHoliday;
import com.tool.smarthrbackend.pojo.attendance.AttendanceRequest;
import com.tool.smarthrbackend.pojo.attendance.AttendanceData;
import com.tool.smarthrbackend.pojo.attendance.AttendanceResponse;
import com.tool.smarthrbackend.pojo.attendance.LeaveAttendanceResponse;
import com.tool.smarthrbackend.pojo.leave.LeaveForAttendance;
import com.tool.smarthrbackend.repository.jpa.attendance.AttendanceRepository;
import com.tool.smarthrbackend.repository.jpa.employee.EmployeeCheckInCheckOutRepository;
import com.tool.smarthrbackend.repository.jpa.employee.EmployeeRepository;
import com.tool.smarthrbackend.repository.jpa.leave.LeaveApplicationRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.AttendanceShiftsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendancerepository;

    @Autowired
    AttendanceShiftsRepository attendanceShiftsRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeCheckInCheckOutRepository employeeCheckInCheckOutRepository;

    @Autowired
    LeaveService leaveService;
    @Autowired
    HolidayService holidayService;

    @Autowired
    LeaveApplicationRepository leaveApplicationRepository;


    public AttendanceResponse getAttendanceDatalist(AttendanceRequest attendanceRequest) {
        Page<Attendance> attendanceList;
        AttendanceResponse attendanceResponse= new AttendanceResponse();
        List<AttendanceData> attendanceDataList = new ArrayList<AttendanceData>();

        //        pagination

        Pageable pageable = PageRequest.of(attendanceRequest.getPageNo(), attendanceRequest.getPageSize());

        attendanceList = attendancerepository.findByEmployeeIdInAndDateBetweenOrderByDateDesc(attendanceRequest.getEmpIdList()
                , attendanceRequest.getToDate(), attendanceRequest.getFromdate(),pageable);
        attendanceList.forEach(attendance -> {

            AttendanceData attendanceData = new AttendanceData();
                Employee employee = attendance.getEmployee();
            List<EmployeeCheckInCheckOut> employeeCheckInCheckOutList=employeeCheckInCheckOutRepository.findByEmployeeIdAndDateOrderByCheckInCheckOutTime(
                    employee.getId(), attendance.getDate());
            attendance.setEmployeeCheckInCheckOutList(
                    employeeCheckInCheckOutRepository.findByEmployeeIdAndDateOrderByCheckInCheckOutTime(
                            employee.getId(), attendance.getDate()
                    )
            );
            Integer totalDuration=0;
                 for (int i=0; i<employeeCheckInCheckOutList.size();i++  ){

                     EmployeeCheckInCheckOut employeeCheckInCheckOut= employeeCheckInCheckOutList.get(i);
                     if (employeeCheckInCheckOut.getWorkDuration()!=null){
                         totalDuration=totalDuration+employeeCheckInCheckOut.getWorkDuration();
                     }


                 }
            attendanceData.setTotalWorkHours(totalDuration);
            attendanceData.setAttendanceId(attendance.getId());
            attendanceData.setEmployeeId(employee.getId());
            attendanceData.setManagerId(employee.getManagerId());
            attendanceData.setFirstName(employee.getFirstName());
            attendanceData.setLastName(employee.getLastName());
            attendanceData.setMiddleName(employee.getMiddleName());
            attendanceData.setDate(attendance.getDate());
            attendanceData.setAttendanceShifts(employee.getAttendanceShifts());
            attendanceData.setEmployeeCheckInCheckOutList(attendance.getEmployeeCheckInCheckOutList());

            attendanceDataList.add(attendanceData);
        });
        List<PublicHoliday> publicHolidayList=holidayService.getHolidayForAttendance(attendanceRequest.getToDate(), attendanceRequest.getFromdate());

        LeaveAttendanceResponse leaveAttendanceResponse=new LeaveAttendanceResponse();
        leaveAttendanceResponse.setEmpIdList(attendanceRequest.getEmpIdList());
        leaveAttendanceResponse.setToDate(attendanceRequest.getToDate());
        leaveAttendanceResponse.setFromDate(attendanceRequest.getFromdate());
        System.out.println(leaveAttendanceResponse+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        List<LeaveForAttendance> leaveForAttendanceList=leaveService.leave(leaveAttendanceResponse);
        attendanceResponse.setPublicHolidayList(publicHolidayList);
        attendanceResponse.setLeaveForAttendanceList(leaveForAttendanceList);
        attendanceResponse.setAttendanceDataList(attendanceDataList);
        attendanceResponse.setTotalElement((int) attendanceList.getTotalElements());
        attendanceResponse.setPageNo(attendanceList.getNumber());
        attendanceResponse.setTotalPage(attendanceList.getTotalPages());
        return attendanceResponse;
    }
}
