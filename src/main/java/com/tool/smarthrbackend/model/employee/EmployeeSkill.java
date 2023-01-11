package com.tool.smarthrbackend.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name ="skill_metadata")
@ToString
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "skill_name")
    String skillName;

    @Column(name = "emp_id")
    Integer empId;


    public EmployeeSkill() {
    }

    public EmployeeSkill(Long id, String skillName, Integer empId) {
        this.id = id;
        this.skillName = skillName;
        this.empId = empId;
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

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
