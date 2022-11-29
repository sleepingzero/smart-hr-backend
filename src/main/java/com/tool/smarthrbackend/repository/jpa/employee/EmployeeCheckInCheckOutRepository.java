package com.tool.smarthrbackend.repository.jpa.employee;

import com.tool.smarthrbackend.model.employee.EmployeeCheckInCheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Convert;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface EmployeeCheckInCheckOutRepository extends JpaRepository<EmployeeCheckInCheckOut,Long> {

     List<EmployeeCheckInCheckOut> findAllByEmployeeId(Integer employeeId) ;

    EmployeeCheckInCheckOut findTop1ByEmployeeIdOrderByCheckInCheckOutTimeDesc(Integer employeeId);


    @Query(
     value = "SELECT e.*  FROM employee_checkin_checkout e WHERE DATE(check_in_check_out_time)=?1 " +
             "And emp_id=?2" ,nativeQuery = true)
     List<EmployeeCheckInCheckOut> findAllByEmployeeIdAndDate(LocalDate date, Integer employeeId );



    //
//@Query(value = "SELECT e.* FROM Entity e WHERE DATE(creation_date) =:date", nativeQuery = true)
//List<Entity> findByCreationDate(LocalDate date);
//     select * from main.employee_checkin_checkout
//     where date(check_in_check_out_time)='2022-08-03' And emp_id=8  ;


    EmployeeCheckInCheckOut findTop1ByEmployeeIdAndStatusOrderByIdDesc(Long empid, boolean Status);

    List<EmployeeCheckInCheckOut> findByemployeeIdAndDateOrderByCheckInCheckOutTime(Long empId , LocalDate date);
}
