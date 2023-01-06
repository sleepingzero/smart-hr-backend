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
        String city;

        @Column(name = "state")
        String state;

        @Column(name = "country")
        String country;

        @Column(name = "pincode")
        String pincode;




        public EmployeeAddress() {
        }

        public EmployeeAddress(Long id, Integer addressType, Integer empId, String addressLine, String city, String state, String country, String pincode) {
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }


    }
