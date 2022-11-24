package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.common.PaginationModel;
import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.employee.*;
import com.tool.smarthrbackend.model.metadata.AttendanceShifts;
import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeRequest;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeResponse;
import com.tool.smarthrbackend.pojo.employee.EmployeeManager;
import com.tool.smarthrbackend.pojo.employee.checkincheckout.EmployeeCheckInCheckOutRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginResponse;
import com.tool.smarthrbackend.repository.jpa.domain.DomainRepository;
import com.tool.smarthrbackend.repository.jpa.employee.*;
import com.tool.smarthrbackend.repository.jpa.metadata.AttendanceShiftsRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.DepartmentRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    AttendanceShiftsRepository attendanceShiftsRepository;

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
        return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(strName, strName);
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
            if (employee.getFirstName() != null) {
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
        EmployeePersonalDetail employeePersonalDetail = new EmployeePersonalDetail();

        BeanUtils.copyProperties(addEmployeeRequest, emp);
        if (!Objects.isNull(addEmployeeRequest.getDepartmentId())) {
            Department department = departmentRepository.findById(addEmployeeRequest.getDepartmentId()).get();
            emp.setDepartment(department);
        }
        if (!Objects.isNull(addEmployeeRequest.getDesignationId())) {
            Domain domain = domainRepository.findById(addEmployeeRequest.getDesignationId()).get();
            emp.setDesignation(domain);
        }
        if(!Objects.isNull(addEmployeeRequest.getAttendanceShiftId())){
            AttendanceShifts shifts=attendanceShiftsRepository.findById(addEmployeeRequest.getAttendanceShiftId()).get();
            emp.setAttendanceShifts(shifts);
        }
        employeePersonalDetail = addEmployeeRequest.getEmployeePersonalDetail();
        emp.setEmployeeAddresses(addEmployeeRequest.getEmployeeAddresses());
        emp.setEmployeeEducations(addEmployeeRequest.getEmployeeEducations());
        emp.setEmployeeProfessionalDetails(addEmployeeRequest.getEmployeeProfessionalDetails());
//        emp.setEmployeePersonalDetail(employeePersonalDetail);


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

        employeePersonalDetail.setEmpId(empid.getId());
        employeePersonalDetailRepository.save(employeePersonalDetail);
        empid.setPersonalDetailId(employeePersonalDetail.getId());

        employeeRepository.save(empid);

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

    public AddEmployeeResponse updateEmployee(Long employeeId, AddEmployeeRequest addEmployeeRequest) {
        Employee emp = null;
        AddEmployeeResponse addEmployeeResponse = new AddEmployeeResponse();
        boolean isExist = employeeRepository.findById(employeeId).isPresent();
        if (isExist == true) {
            emp = employeeRepository.findById(employeeId).get();
            if (!Objects.isNull(addEmployeeRequest.getDepartmentId())) {
                Department department = departmentRepository.findById(addEmployeeRequest.getDepartmentId()).get();
                emp.setDepartment(department);
            }
            if (!Objects.isNull(addEmployeeRequest.getDesignationId())) {
                Domain domain = domainRepository.findById(addEmployeeRequest.getDesignationId()).get();
                emp.setDesignation(domain);
            }
            emp.setFirstName(addEmployeeRequest.getFirstName());
            emp.setMiddleName(addEmployeeRequest.getMiddleName());
            emp.setLastName(addEmployeeRequest.getLastName());
            emp.setPhoneNumber(addEmployeeRequest.getPhoneNumber());
            emp.setPersonalEmailId(addEmployeeRequest.getPersonalEmailId());
            emp.setProfessionalEmailId(addEmployeeRequest.getProfessionalEmailId());

            updateAddress(addEmployeeRequest.getEmployeeAddresses());
            updateEducation(addEmployeeRequest.getEmployeeEducations());
            updateProfessionalDetail(addEmployeeRequest.getEmployeeProfessionalDetails());
            updatePersonalDetail(addEmployeeRequest.getEmployeePersonalDetail());
            updateFamilyDetail(addEmployeeRequest.getEmployeeFamilyDetail());


            employeeRepository.save(emp);
            addEmployeeResponse.setReturnMsg("successfully update");

            return addEmployeeResponse;
        } else {
            addEmployeeResponse.setReturnMsg("employee not present");
            return addEmployeeResponse;
        }

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
                ExistingEmployeeAddress.setAddressLine(address.getAddressLine());
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

    public void updatePersonalDetail(EmployeePersonalDetail employeePersonalDetail) {
        EmployeePersonalDetail existEmployeePersonalDetail1 = null;
        if (employeePersonalDetail.getId() != null) {
            existEmployeePersonalDetail1 = employeePersonalDetailRepository.findById(employeePersonalDetail.getId()).get();
            existEmployeePersonalDetail1.setMaritalStatus(employeePersonalDetail.getMaritalStatus());
            existEmployeePersonalDetail1.setGender(employeePersonalDetail.getGender());
            existEmployeePersonalDetail1.setNationality(employeePersonalDetail.getNationality());
            existEmployeePersonalDetail1.setBloodGroup(employeePersonalDetail.getBloodGroup());
            existEmployeePersonalDetail1.setDateOfBirth(employeePersonalDetail.getDateOfBirth());

            employeePersonalDetailRepository.save(existEmployeePersonalDetail1);
        } else {
            employeePersonalDetailRepository.save(employeePersonalDetail);
        }

    }

    public void updateFamilyDetail(EmployeeFamilyDetail employeeFamilyDetail) {
        EmployeeFamilyDetail existingEmployeeFamilyDetail = null;
        if (employeeFamilyDetail != null) {

        }
    }

    //    to update employee education
    public void updateEducation(List<EmployeeEducation> employeeEducations) {
        employeeEducations.forEach(eduction -> {
            EmployeeEducation existingEmployeeEducation = null;
            if (eduction.getId() != null) {
                existingEmployeeEducation = employeeEducationRepository.findById(eduction.getId()).get();
                existingEmployeeEducation.setDegree(eduction.getDegree());
                existingEmployeeEducation.setSpecialization(eduction.getSpecialization());
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
        employeeProfessionalDetail.forEach(professional -> {
            EmployeeProfessionalDetail existingEmployeeProfessionalDetail = null;
            if (professional.getId() != null) {
                existingEmployeeProfessionalDetail = employeeProfessionalDetailRepository.findById(professional.getId()).get();
                existingEmployeeProfessionalDetail.setCompany(professional.getCompany());
                existingEmployeeProfessionalDetail.setDesignation(professional.getDesignation());
                existingEmployeeProfessionalDetail.setSkill(professional.getSkill());
                existingEmployeeProfessionalDetail.setRoleAndResponsibility(professional.getRoleAndResponsibility());
                existingEmployeeProfessionalDetail.setStartDate(professional.getStartDate());
                existingEmployeeProfessionalDetail.setEndDate(professional.getEndDate());
                existingEmployeeProfessionalDetail.setCity(professional.getCity());
                existingEmployeeProfessionalDetail.setState(professional.getState());
                existingEmployeeProfessionalDetail.setCountry(professional.getCountry());
                existingEmployeeProfessionalDetail.setPincode(professional.getPincode());

                employeeProfessionalDetailRepository.save(existingEmployeeProfessionalDetail);
            } else {
                employeeProfessionalDetailRepository.save(professional);

            }
        });

    }

    public Page<EmployeePersonalDetail> getUpcomingBirthday(Integer limit, PaginationModel paginationModel) {
        Page<EmployeePersonalDetail> employeePersonalDetailPage = null;
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

//        pagination
        String sortBy = paginationModel.getSortBy();
        Pageable pageable = PageRequest.of(paginationModel.getPageNo(), paginationModel.getPageSize());


        if (limit == null) {
            employeePersonalDetailPage = employeePersonalDetailRepository.findAllUpcomingBirthday(currrentDate, futureDate, pageable);

            System.out.println(employeePersonalDetailPage);
            employeePersonalDetailPage.forEach(personalDetail -> {
                Employee employee = null;
                employee = employeeRepository.findById(personalDetail.getEmpId()).get();
                personalDetail.setEmployee(employee);
                System.out.println(personalDetail);
            });

//            return employeePersonalDetailPage;
        }
        return employeePersonalDetailPage;
    }


    public EmployeeManager getEmployeeById(Long employeeId) {
        Employee employee;
        Employee manager;
        EmployeePersonalDetail employeePersonalDetail = null;

        employee = employeeRepository.findById(employeeId).get();
        employeePersonalDetail = employeePersonalDetailRepository.findById(employee.getPersonalDetailId()).get();
        employee.setEmployeePersonalDetail(employeePersonalDetail);
        manager = employeeRepository.findById(employee.getManagerId()).get();

        System.out.println("manager" + manager);
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.setEmployee(employee);
        employeeManager.setManager(manager);
        System.out.println("smkskdskmks" + employeeManager);

        return employeeManager;
    }


    public List<Employee> getTeamList(Long managerId) {
        
   return employeeRepository.findAllByManagerId(managerId);
    }
}
