package com.tool.smarthrbackend.model.metadata;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="attendance_shifts")
public class AttendanceShifts {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @Column(name= "shift_name")
    String shiftName;


    @Column(name= "shift_start_hour")
    Integer shiftStartHour;

    @Column(name= "shift_start_minute")
    Integer shiftStartMinute;

    @Column(name= "shift_am_or_pm")
    String shiftAmOrPm;

    @Column(name= "total_shift_time_in_hours")
    Integer totalShiftTimeInHours;
}
