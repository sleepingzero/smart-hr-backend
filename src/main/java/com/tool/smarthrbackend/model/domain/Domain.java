package com.tool.smarthrbackend.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "domains")
public class Domain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name= "domain_name")
    String domainName;

    @Column(name= "domain_desc")
    String domainDesc;

    @Column(name= "domain_display_name")
    String domainDisplayName;

    @Column(name = "parent_id")
    Long parentId;

    @Column(name= "data_type")
    String dataType;

    @Column(name="int_value")
    Long intValue;

    @Column(name="varchar_val")
    Long varcharValue;

    @Column(name="date_val")
    Date dateVal;

    @Column(name="created_date",updatable = false)
    Date createdDate;

    @Column(name="updated_date")
    Date updatedDate;

    @Column(name = "active")
    Integer active;

        @JsonProperty
    @Transient
    Integer edit = 0;



}
