package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="employee_checkin_checkout")
@ToString
public class EmployeeCheckInCheckOut {


        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "id")
        Long id;



        @Column(name = "emp_id")
        Integer employeeId;

       @Column(name="check_in_check_out_time")

       LocalDateTime checkInCheckOutTime;

        @Column(name="status")
        Boolean status;





    public EmployeeCheckInCheckOut() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getCheckInCheckOutTime() {
        return checkInCheckOutTime;
    }

    public void setCheckInCheckOutTime(LocalDateTime checkInCheckOutTime) {
        this.checkInCheckOutTime = checkInCheckOutTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
