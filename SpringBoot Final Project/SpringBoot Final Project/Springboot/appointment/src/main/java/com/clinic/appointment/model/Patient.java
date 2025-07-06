package com.clinic.appointment.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String contact;
    private String healthIssue;
    private String slot; // "Morning" or "Evening"
    private int waitlistNumber;
    private LocalDate appointmentDate;
    private boolean metDoctor;

    // Getters and Setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(String healthIssue) {
        this.healthIssue = healthIssue;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public int getWaitlistNumber() {
        return waitlistNumber;
    }

    public void setWaitlistNumber(int waitlistNumber) {
        this.waitlistNumber = waitlistNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public boolean isMetDoctor() {
        return metDoctor;
    }

    public void setMetDoctor(boolean metDoctor) {
        this.metDoctor = metDoctor;
    }
}

