package com.tool.smarthrbackend.model.holiday;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "public_holidays")
public class PublicHoliday {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "country_id")
    Long countryId;

    @Column(name = "firm_location_id")
    Long firmLocationId;

    @Column(name = "holiday_year")
    Long holidayYear;

    @Column(name = "holiday_month")
    Long holidayMonth;

    @Column(name = "holiday_day")
    Long holidayDay;

    @Column(name = "holiday_name")
    String holidayName;

    @Column(name = "holiday_desc")
    String holidayDesc;





}
