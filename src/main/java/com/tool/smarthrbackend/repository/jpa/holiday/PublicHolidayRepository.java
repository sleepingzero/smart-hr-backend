package com.tool.smarthrbackend.repository.jpa.holiday;


import com.tool.smarthrbackend.model.holiday.PublicHoliday;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PublicHolidayRepository extends CrudRepository<PublicHoliday, Long> {
    Optional<PublicHoliday> findById(Long id);

    List<PublicHoliday> findByHolidayYear(Long holidayYear);

    @Override
    List<PublicHoliday> findAll();

    Page<PublicHoliday> findByHolidayYear(Long year, Pageable pageable);

    List<PublicHoliday> findByHolidayDateBetween(LocalDate startDate ,LocalDate endDate);
}