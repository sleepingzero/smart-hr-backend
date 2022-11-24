package com.tool.smarthrbackend.model.metadata;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name ="attendance_shifts")
@ToString
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


    public AttendanceShifts() {
    }

    public AttendanceShifts(Long id, String shiftName, Integer shiftStartHour, Integer shiftStartMinute, String shiftAmOrPm, Integer totalShiftTimeInHours) {
        this.id = id;
        this.shiftName = shiftName;
        this.shiftStartHour = shiftStartHour;
        this.shiftStartMinute = shiftStartMinute;
        this.shiftAmOrPm = shiftAmOrPm;
        this.totalShiftTimeInHours = totalShiftTimeInHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public Integer getShiftStartHour() {
        return shiftStartHour;
    }

    public void setShiftStartHour(Integer shiftStartHour) {
        this.shiftStartHour = shiftStartHour;
    }

    public Integer getShiftStartMinute() {
        return shiftStartMinute;
    }

    public void setShiftStartMinute(Integer shiftStartMinute) {
        this.shiftStartMinute = shiftStartMinute;
    }

    public String getShiftAmOrPm() {
        return shiftAmOrPm;
    }

    public void setShiftAmOrPm(String shiftAmOrPm) {
        this.shiftAmOrPm = shiftAmOrPm;
    }

    public Integer getTotalShiftTimeInHours() {
        return totalShiftTimeInHours;
    }

    public void setTotalShiftTimeInHours(Integer totalShiftTimeInHours) {
        this.totalShiftTimeInHours = totalShiftTimeInHours;
    }
}
