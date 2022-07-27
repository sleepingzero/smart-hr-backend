package com.tool.smarthrbackend.service;

import com.tool.smarthrbackend.model.domain.Domain;
import com.tool.smarthrbackend.model.employee.Employee;
import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeRequest;
import com.tool.smarthrbackend.pojo.employee.AddEmployeeResponse;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginRequest;
import com.tool.smarthrbackend.pojo.login.EmployeeLoginResponse;
import com.tool.smarthrbackend.repository.jpa.domain.DomainRepository;
import com.tool.smarthrbackend.repository.jpa.employee.EmployeeRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.DepartmentRepository;
import com.tool.smarthrbackend.repository.jpa.metadata.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
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
    RoleRepository roleRepository;

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }



    public Employee getEmployeeById(Long employeeId){
        return  employeeRepository.findById(employeeId).get();
    }

     public  List<Employee> getEmployeesBySearchTerm(String strName){
        return  employeeRepository.findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase( strName,strName);
     }


     public EmployeeLoginResponse login (EmployeeLoginRequest employeeLoginRequest) throws Exception {
            String userName = employeeLoginRequest.getUsername();
            EmployeeLoginResponse employeeLoginResponse = new EmployeeLoginResponse();
            Employee employee = null;
            System.out.println(employeeLoginRequest);
            if(isNumeric(userName)){
              employee =  employeeRepository.findById(Long.parseLong(userName)).get();
               }
            else{
                employee =  employeeRepository.findByPersonalEmailId(userName.trim()).get();
            }
            System.out.println(employee);
            if(employee.getId()==null)
                throw new Exception("Employee is not found");

            if(employeeLoginRequest.getIsOTP()==true) {
                if(employee.getTmpPasswordOtp()!=null
                        && employeeLoginRequest.getOtp().equals(employee.getTmpPasswordOtp())) {
                    employee.setEmpPassword(employeeLoginRequest.getPassword());
                    employeeRepository.save(employee);
                    employeeLoginResponse.setIsError(false);
                    employeeLoginResponse.setEmployee(employee);
                }else{
                    employeeLoginResponse.setIsError(true);
                    employeeLoginResponse.setErrorMsg(" OTP did not match to given data");
                }
            }else{
                if(employee.getName() != null) {
                    if(employee.getEmpPassword().equals(employeeLoginRequest.getPassword())) {
                        employeeLoginResponse.setIsError(false);
                        employeeLoginResponse.setEmployee(employee);
                    }else{
                        employeeLoginResponse.setIsError(true);
                        employeeLoginResponse.setEmployee(null);
                        employeeLoginResponse.setErrorMsg("Password does not match");
                    }

                }else {
                    employeeLoginResponse.setIsError(true);
                    employeeLoginResponse.setErrorMsg("Username /password did not match");
                }
                }
            return  employeeLoginResponse;
     }


   public AddEmployeeResponse addEmployee (AddEmployeeRequest addEmployeeRequest) {
       Employee emp = new Employee();
       AddEmployeeResponse addEmployeeResponse = new AddEmployeeResponse();
       BeanUtils.copyProperties(addEmployeeRequest,emp);
       if(!Objects.isNull(addEmployeeRequest.getDepartmentId())) {
           Department department = departmentRepository.findById(addEmployeeRequest.getDepartmentId()).get();
           emp.setDepartment(department);
       }
       if(!Objects.isNull(addEmployeeRequest.getDesignationId())) {
           Domain domain = domainRepository.findById(addEmployeeRequest.getDesignationId()).get();
           emp.setDesignation(domain);
       }

       if(addEmployeeRequest!= null && addEmployeeRequest.getRoles()!=null && addEmployeeRequest.getRoles().size() >0){
          emp.setRole( roleRepository.findById(addEmployeeRequest.getRoles().get(0)).get());
       }

       if(addEmployeeRequest.getIsFirstTimeCreation()) {
          Long firstTimeOtp =   getFirstTimeOTPNumber();
          emp.setTmpPasswordOtp(firstTimeOtp);
          addEmployeeResponse.setGeneratedTmpOtp(firstTimeOtp);
       }
      Employee empid =  employeeRepository.save(emp);
      addEmployeeResponse.setGeneratedEmpId(empid.getId());
    return addEmployeeResponse;
   }

   private Long getFirstTimeOTPNumber(){
       Random random = new Random();
       StringBuffer stb = new StringBuffer();

       for(int i=0; i < 6 ;i++){
           stb.append(random.nextInt(10));
       }

       return  Long.parseLong(stb.toString());
   }






}
