package com.tool.smarthrbackend.pojo.leave;

import java.util.List;

public class LeaveStatusUpdate {
    List<Long> idList;
    String status;

    public LeaveStatusUpdate(List<Long> idList, String status) {
        this.idList = idList;
        this.status = status;
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
}
