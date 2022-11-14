package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeePersonalDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePersonalDetailRepository extends JpaRepository<EmployeePersonalDetail, Long> {

    @Query(nativeQuery = true,value = "select * from main.employee_personal_details " +
            " where DATE_FORMAT(main.employee_personal_details.date_Of_birth,'%m-%d')\n" +
            "between ?1 and ?2 order by DATE_FORMAT(main.employee_personal_details.date_Of_birth,'%m-%d') limit ?3")
          Page<EmployeePersonalDetail> findTop3(String currentDate , String futureDate, Integer limit, Pageable pageable);

    @Query(nativeQuery = true,value = "select * from main.employee_personal_details " +
            " where DATE_FORMAT(main.employee_personal_details.date_Of_birth,'%m-%d')\n" +
            "between ?1 and ?2 order by DATE_FORMAT(main.employee_personal_details.date_Of_birth,'%m-%d') ")
    Page<EmployeePersonalDetail> findAllUpcomingBirthday(String currentDate , String futureDate, Pageable pageable);

}
