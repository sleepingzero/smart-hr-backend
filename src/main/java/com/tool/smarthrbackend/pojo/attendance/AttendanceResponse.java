package com.tool.smarthrbackend.pojo.attendance;

import java.util.List;

public class AttendanceResponse {
    List<AttendanceData> attendanceDataList;
    int totalElement;
    int totalPage;
    int pageNo;

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
