package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.employee.*;
import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeRequest;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeResponse;
import com.tool.smarthrbackend.pojo.employee.EmployeeManager;
import com.tool.smarthrbackend.pojo.employee.checkincheckout.EmployeeCheckInCheckOutRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginResponse;
import com.tool.smarthrbackend.repository.jpa.domain.DomainRepository;
import com.tool.smarthrbackend.repository.jpa.employee.*;
import com.tool.smarthrbackend.repository.jpa.metadata.DepartmentRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DomainRepository domainRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeCheckInCheckOutRepository employeeCheckInCheckOutRepository;

    @Autowired
    EmployeeAddressRepository employeeAddressRepository;

    @Autowired
    EmployeeEducationRepository employeeEducationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EmployeePersonalDetailRepository employeePersonalDetailRepository;

    @Autowired
    EmployeeProfessionalDetailRepository employeeProfessionalDetailRepository;

    @Autowired
    EmployeeFamilyDetailRepository employeeFamilyDetailRepository;

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }


//    public Employee getEmployeeById(Long employeeId) {
//
//        return employeeRepository.findById(employeeId).get();
//    }

    public List<Employee> getEmployeesBySearchTerm(String strName) {
        return employeeRepository.findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(strName, strName);
    }


    public EmployeeLoginResponse login(EmployeeLoginRequest employeeLoginRequest) throws Exception {
        String userName = employeeLoginRequest.getUsername();
        EmployeeLoginResponse employeeLoginResponse = new EmployeeLoginResponse();
        Employee employee = null;
        System.out.println(employeeLoginRequest);
        if (isNumeric(userName)) {
            employee = employeeRepository.findById(Long.parseLong(userName)).get();
        } else {
            employee = employeeRepository.findByPersonalEmailId(userName.trim()).get();
        }
        System.out.println(employee);
        if (employee.getId() == null)
            throw new Exception("Employee is not found");

        if (employeeLoginRequest.getIsOTP() == true) {
            if (employee.getTmpPasswordOtp() != null
                    && employeeLoginRequest.getOtp().equals(employee.getTmpPasswordOtp())) {
                employee.setEmpPassword(employeeLoginRequest.getPassword());
                employeeRepository.save(employee);
                employeeLoginResponse.setIsError(false);
                employeeLoginResponse.setEmployee(employee);
            } else {
                employeeLoginResponse.setIsError(true);
                employeeLoginResponse.setErrorMsg(" OTP did not match to given data");
            }
        } else {
            if (employee.getName() != null) {
                if (employee.getEmpPassword().equals(employeeLoginRequest.getPassword())) {
                    employeeLoginResponse.setIsError(false);
                    employeeLoginResponse.setEmployee(employee);
                } else {
                    employeeLoginResponse.setIsError(true);
                    employeeLoginResponse.setEmployee(null);
                    employeeLoginResponse.setErrorMsg("Password does not match");
                }

            } else {
                employeeLoginResponse.setIsError(true);
                employeeLoginResponse.setErrorMsg("Username /password did not match");
            }
        }
        return employeeLoginResponse;
    }


    public AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest) {
        Employee emp = new Employee();
//        EmployeePersonalDetail personalDetail=new EmployeePersonalDetail();
        AddEmployeeResponse addEmployeeResponse = new AddEmployeeResponse();
        BeanUtils.copyProperties(addEmployeeRequest, emp);
        if (!Objects.isNull(addEmployeeRequest.getDepartmentId())) {
            Department department = departmentRepository.findById(addEmployeeRequest.getDepartmentId()).get();
            emp.setDepartment(department);
        }
        if (!Objects.isNull(addEmployeeRequest.getDesignationId())) {
            Domain domain = domainRepository.findById(addEmployeeRequest.getDesignationId()).get();
            emp.setDesignation(domain);
        }
        emp.setEmployeeAddresses(addEmployeeRequest.getEmployeeAddresses());
        emp.setEmployeeEducations(addEmployeeRequest.getEmployeeEducations());
        emp.setEmployeeProfessionalDetails(addEmployeeRequest.getEmployeeProfessionalDetails());
        emp.setEmployeePersonalDetail(addEmployeeRequest.getEmployeePersonalDetail());
        emp.setEmployeeFamilyDetail(addEmployeeRequest.getEmployeeFamilyDetail());


//       if(addEmployeeRequest!= null && addEmployeeRequest.getRoles()!=null && addEmployeeRequest.getRoles().size() >0){
//          emp.setRole( roleRepository.findById(addEmployeeRequest.getRoles().get(0)).get());
//       }

        if (addEmployeeRequest.getIsFirstTimeCreation()) {
            Long firstTimeOtp = getFirstTimeOTPNumber();
            emp.setTmpPasswordOtp(firstTimeOtp);
            addEmployeeResponse.setGeneratedTmpOtp(firstTimeOtp);
        }
        Employee empid = employeeRepository.save(emp);
        addEmployeeResponse.setGeneratedEmpId(empid.getId());
        return addEmployeeResponse;
    }

    private Long getFirstTimeOTPNumber() {
        Random random = new Random();
        StringBuffer stb = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            stb.append(random.nextInt(10));
        }

        return Long.parseLong(stb.toString());
    }

    public EmployeeCheckInCheckOutRequest addCheckin(EmployeeCheckInCheckOutRequest employeeCheckInCheckOutRequest) {
        EmployeeCheckInCheckOut employeeCheckInCheckOut = new EmployeeCheckInCheckOut();
        employeeCheckInCheckOut.setEmployeeId(employeeCheckInCheckOutRequest.getEmployeeId());
        employeeCheckInCheckOut.setStatus(employeeCheckInCheckOutRequest.getStatus());
        employeeCheckInCheckOut.setCheckInCheckOutTime(LocalDateTime.now());
        employeeCheckInCheckOutRepository.save(employeeCheckInCheckOut);
        return employeeCheckInCheckOutRequest;
    }

    public List<EmployeeCheckInCheckOut> getEmployeeCheckInCheckOutAllById(Integer employeeId) {

        return employeeCheckInCheckOutRepository.findAllByEmployeeId(employeeId);

    }


    public List<EmployeeCheckInCheckOut> getEmployeeCheckInCheckOutByDate(LocalDate date, Integer employeeId) {
        System.out.println(date);
        if (date == null) {
            LocalDate currentdate = LocalDate.now();
            date = currentdate;
        }
        System.out.println(date + " service");
        return employeeCheckInCheckOutRepository.findAllByEmployeeIdAndDate(date, employeeId);

    }

    public EmployeeCheckInCheckOut getEmployeeCheckInCheckOutStatus(Integer employeeId) {

        return employeeCheckInCheckOutRepository.findTop1ByEmployeeIdOrderByCheckInCheckOutTimeDesc(employeeId);
    }


// to update the address of employee

    public void updateAddress(List<EmployeeAddress> employeeAddresses) {
        employeeAddresses.forEach(address -> {
            EmployeeAddress ExistingEmployeeAddress = null;
            if (address.getId() != null) {
                ExistingEmployeeAddress = employeeAddressRepository.findById(address.getId()).get();
                ExistingEmployeeAddress.setAddressType(address.getAddressType());
                ExistingEmployeeAddress.setAddressLine1(address.getAddressLine1());
                ExistingEmployeeAddress.setAddressLine2(address.getAddressLine2());
                ExistingEmployeeAddress.setAddressLine3(address.getAddressLine3());
                ExistingEmployeeAddress.setCity(address.getCity());
                ExistingEmployeeAddress.setState(address.getState());
                ExistingEmployeeAddress.setCountry(address.getCountry());
                ExistingEmployeeAddress.setPincode(address.getPincode());

                employeeAddressRepository.save(ExistingEmployeeAddress);
            } else {
                employeeAddressRepository.save(address);
            }

        });


    }

    //    to update employee education
    public void updateEducation(List<EmployeeEducation> employeeEducations) {
        employeeEducations.forEach(eduction -> {
            EmployeeEducation existingEmployeeEducation = null;
            if (eduction.getId() != null) {
                existingEmployeeEducation = employeeEducationRepository.findById(eduction.getId()).get();
                existingEmployeeEducation.setDegree(eduction.getDegree());
                existingEmployeeEducation.setField(eduction.getField());
                existingEmployeeEducation.setGrade(eduction.getGrade());
                existingEmployeeEducation.setInstitute(eduction.getInstitute());
                existingEmployeeEducation.setStartDate(eduction.getStartDate());
                existingEmployeeEducation.setEndDate(eduction.getEndDate());
                existingEmployeeEducation.setCity(eduction.getCity());
                existingEmployeeEducation.setState(eduction.getState());
                existingEmployeeEducation.setCountry(eduction.getCountry());
                existingEmployeeEducation.setPincode(eduction.getPincode());

                employeeEducationRepository.save(existingEmployeeEducation);
            } else {
                employeeEducationRepository.save(eduction);
            }
        });


    }
    public void updateProfessionalDetail(List<EmployeeProfessionalDetail> employeeProfessionalDetail) {
    employeeProfessionalDetail.forEach(professional->{
        EmployeeProfessionalDetail existingEmployeeProfessionalDetail=null;
        if (professional.getId() != null) {
          existingEmployeeProfessionalDetail=employeeProfessionalDetailRepository.findById(professional.getId()).get();
            existingEmployeeProfessionalDetail.setCompany(professional.getCompany());
            existingEmployeeProfessionalDetail.setDesignation(professional.getDesignation());
            existingEmployeeProfessionalDetail.setSkill(professional.getSkill());
            existingEmployeeProfessionalDetail.setRole1(professional.getRole1());
            existingEmployeeProfessionalDetail.setRole2(professional.getRole2());
            existingEmployeeProfessionalDetail.setRole3(professional.getRole3());
            existingEmployeeProfessionalDetail.setStartDate(professional.getStartDate());
            existingEmployeeProfessionalDetail.setEndDate(professional.getEndDate());
            existingEmployeeProfessionalDetail.setCity(professional.getCity());
            existingEmployeeProfessionalDetail.setState(professional.getState());
            existingEmployeeProfessionalDetail.setCountry(professional.getCountry());
            existingEmployeeProfessionalDetail.setPincode(professional.getPincode());

         employeeProfessionalDetailRepository.save(existingEmployeeProfessionalDetail);
        }
        else {
            employeeProfessionalDetailRepository.save(professional);

        }
    });

    }

    public List<EmployeePersonalDetail> getUpcomingBirthday(Integer limit) {
//        to get calendar date of today and date after month
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1); // n is the number of days upto which to be calculated
        Date futureDateCal = calendar.getTime();
//        formate date
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd");
        Date dateToday = new Date();

        String currrentDate = format1.format(dateToday);
        String futureDate = format1.format(futureDateCal);

        if (limit == null) {
            return employeePersonalDetailRepository.findAllUpcomingBirthday(currrentDate, futureDate);
        } else {
            return employeePersonalDetailRepository.findTop3(currrentDate, futureDate,limit);
        }

    }


    public EmployeeManager getEmployeeById(Long employeeId) {
        Employee employee;
        Employee manager;

        employee=employeeRepository.findById(employeeId).get();
//        System.out.println("hdjffffffffffdj" +employee.getManagerId());
        manager= employeeRepository.findById(employee.getManagerId()).get();
//        System.out.println("hdjffffffffffdj" +employee);
        System.out.println("manager"+ manager);
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.setEmployee(employee);
        employeeManager.setManager(manager);
        System.out.println("smkskdskmks"+employeeManager);

        return employeeManager;
    }
}
