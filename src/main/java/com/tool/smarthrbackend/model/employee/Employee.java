package com.tool.smarthrbackend.model.employee;

import com.tool.smarthrbackend.model.metadata.Department;
import com.tool.smarthrbackend.model.metadata.Role;
import com.tool.smarthrbackend.model.domain.Domain;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Data
@Entity
@Table(name ="employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "middle_name")
    String middleName;

    @Column(name = "personal_email_id")
    String personalEmailId;

    @Column(name = "professional_email_id")
    String professionalEmailId;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "phone_number")
    Long  phoneNumber;

    @Column(name = "emp_password")
    String empPassword;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    @Column(name = "project_id")
    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Domain designation;

    @Column(name = "tmp_password_otp")
    private Long tmpPasswordOtp;

}
