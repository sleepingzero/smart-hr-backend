package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.sleepingZero.ContactUs;
import com.tool.smarthrbackend.repository.jpa.sleepingZero.SleepingZeroContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SleepingZeroService {

    @Autowired
    SleepingZeroContactUsRepository sleepingZeroContactUsRepository;
    public ContactUs addContactUs(ContactUs contactUs) {
        return sleepingZeroContactUsRepository.save(contactUs);
    }
}
