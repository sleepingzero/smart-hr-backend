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

        @Column(name = "address_line1")
        String addressLine1;

        @Column(name = "address_line2")
        String addressLine2;

        @Column(name = "address_line3")
        String addressLine3;

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

        public EmployeeAddress(Long id, Integer addressType, Integer emp_id, String addressLine1, String addressLine2, String addressLine3, Integer city, Integer state, Integer country, String pincode) {
            this.id = id;
            this.addressType = addressType;
            this.empId = empId;
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.addressLine3 = addressLine3;
            this.city = city;
            this.state = state;
            this.country = country;
            this.pincode = pincode;
        }

        public Integer getEmpId() {
            return empId;
        }

        public void setEmpId(Integer empId) {
            this.empId = empId;
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

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getAddressLine3() {
            return addressLine3;
        }

        public void setAddressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
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
