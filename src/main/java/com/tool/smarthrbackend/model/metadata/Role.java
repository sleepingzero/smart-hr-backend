package com.tool.smarthrbackend.model.metadata;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @Column(name= "role_name")
    String roleName;


    @Column(name= "role_desc")
    String roleDesc;

}
