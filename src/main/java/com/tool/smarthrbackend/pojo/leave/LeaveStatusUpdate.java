package com.tool.smarthrbackend.pojo.leave;

import java.util.List;

public class LeaveStatusUpdate {
    List<Long> idList;
    String status;

    Integer approvedById;

    public LeaveStatusUpdate() {
    }

    public LeaveStatusUpdate(List<Long> idList, String status, Integer approvedById) {
        this.idList = idList;
        this.status = status;
        this.approvedById = approvedById;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(Integer approvedById) {
        this.approvedById = approvedById;
    }
}
