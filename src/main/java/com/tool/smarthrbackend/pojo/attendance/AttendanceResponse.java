package com.tool.smarthrbackend.pojo.attendance;

import com.tool.smarthrbackend.model.holiday.PublicHoliday;
import com.tool.smarthrbackend.pojo.leave.LeaveForAttendance;

import java.util.List;

public class AttendanceResponse {
    List<AttendanceData> attendanceDataList;
    List<LeaveForAttendance> leaveForAttendanceList;

    List<PublicHoliday> publicHolidayList;
    int totalElement;
    int totalPage;
    int pageNo;


    public List<PublicHoliday> getPublicHolidayList() {
        return publicHolidayList;
    }

    public void setPublicHolidayList(List<PublicHoliday> publicHolidayList) {
        this.publicHolidayList = publicHolidayList;
    }

    public List<LeaveForAttendance> getLeaveForAttendanceList() {
        return leaveForAttendanceList;
    }

    public void setLeaveForAttendanceList(List<LeaveForAttendance> leaveForAttendanceList) {
        this.leaveForAttendanceList = leaveForAttendanceList;
    }

    public List<AttendanceData> getAttendanceDataList() {
        return attendanceDataList;
    }

    public void setAttendanceDataList(List<AttendanceData> attendanceDataList) {
        this.attendanceDataList = attendanceDataList;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
