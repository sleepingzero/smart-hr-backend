package com.tool.smarthrbackend.repository.jpa.sleepingZero;

import com.tool.smarthrbackend.model.sleepingZero.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepingZeroContactUsRepository extends JpaRepository<ContactUs,Long> {
}
