package com.tool.smarthrbackend.repository.jpa.metadata;


import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceShiftsRepository extends CrudRepository<AttendanceShifts, Long> {
    Optional<AttendanceShifts> findById(Long id);

    @Override
    List<AttendanceShifts> findAll();

}