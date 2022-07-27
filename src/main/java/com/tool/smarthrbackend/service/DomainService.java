package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.holiday.PublicHoliday;
import com.tool.smarthrbackend.repository.jpa.domain.DomainRepository;
import com.tool.smarthrbackend.repository.jpa.holiday.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DomainService {

    @Autowired
    DomainRepository domainRepository;



    public List<Domain> findChildDomainsByDomainName(String domainName){
        return  domainRepository.findChildDomainsByDomainName(domainName);
    }


    public Domain getDomainByDomainName(String domainName){
        return  domainRepository.findByDomainName(domainName);
    }

    public void saveDomain(Domain domain){
          domain.setCreatedDate(new Date());
          domain.setUpdatedDate(new Date());
          domainRepository.save(domain);
    }





}
