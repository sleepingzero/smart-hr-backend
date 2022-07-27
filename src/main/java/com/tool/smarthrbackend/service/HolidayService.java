package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.holiday.PublicHoliday;
import com.tool.smarthrbackend.repository.jpa.holiday.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HolidayService {

    @Autowired
    PublicHolidayRepository publicHolidayRepository;

    //sumtill100(100);
    //sumtill100(200);
// sumtill100 = (a:number) : number =>{
 Integer sumtill100( Integer a){
     Integer sum = 0;
     for(int i =0;i<=a;i++){
         sum = sum+i;
     }
     return  sum;
 }


public List<PublicHoliday> getPublicHolidaysByYear(){
    return  publicHolidayRepository.findAll();
}

//  findByYear = (year:number): PublicHolidy[]{ ret}
    public List<PublicHoliday> findByYear(Long year){
        return  publicHolidayRepository.findByHolidayYear(year);
    }





}
