package com.tool.smarthrbackend.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;



    @Data
    @Entity
    @Table(name ="employee_address")
    @ToString
  public class EmployeeAddress {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "id")
        Long id;

        @Column(name = "address_type")
        Integer addressType;

        @Column(name = "emp_id")
        Integer empId;

        @Column(name = "address_line")
        String addressLine;


        @Column(name = "city")
        Integer city;

        @Column(name = "state")
        Integer state;

        @Column(name = "country")
        Integer country;

        @Column(name = "pincode")
        String pincode;




        public EmployeeAddress() {
        }

        public EmployeeAddress(Long id, Integer addressType, Integer empId, String addressLine, Integer city, Integer state, Integer country, String pincode) {
            this.id = id;
            this.addressType = addressType;
            this.empId = empId;
            this.addressLine = addressLine;
            this.city = city;
            this.state = state;
            this.country = country;
            this.pincode = pincode;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getAddressType() {
            return addressType;
        }

        public void setAddressType(Integer addressType) {
            this.addressType = addressType;
        }

        public Integer getEmpId() {
            return empId;
        }

        public void setEmpId(Integer empId) {
            this.empId = empId;
        }

        public String getAddressLine() {
            return addressLine;
        }

        public void setAddressLine(String addressLine) {
            this.addressLine = addressLine;
        }

        public Integer getCity() {
            return city;
        }

        public void setCity(Integer city) {
            this.city = city;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public Integer getCountry() {
            return country;
        }

        public void setCountry(Integer country) {
            this.country = country;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }


    }
