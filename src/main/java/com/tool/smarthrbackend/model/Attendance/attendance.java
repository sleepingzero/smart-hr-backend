package com.tool.smarthrbackend.model.Attendance;

import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "attendance")
@ToString

public class attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public  Long id;
//
//    @Column(name = "emp_id")
//    public Employee employee;
//
//    @Column(name = "shift_id")
//    public AttendanceShifts attendanceShifts;

    @Column(name = "current_date")
    public LocalDate currentDate;




}
