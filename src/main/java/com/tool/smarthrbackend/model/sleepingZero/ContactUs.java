package com.tool.smarthrbackend.model.sleepingZero;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sleepingzero_contact_us")
@ToString
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "subject")
    String subject;

    @Column(name = "description")
    String description;

    @Column(name = "phone_number")
    String phoneNumber;

    public ContactUs() {
    }

    public ContactUs(String name, String emailId, String subject, String description, String phoneNumber) {
        this.name = name;
        this.emailId = emailId;
        this.subject = subject;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
