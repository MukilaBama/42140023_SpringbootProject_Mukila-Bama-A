package com.clinic.appointment.controller;

import com.clinic.appointment.model.Patient;
import com.clinic.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/view-status")
    public String viewStatusByName(@RequestParam String name, Model model) {
        Optional<Patient> patient = patientRepository.findTopByNameOrderByIdDesc(name);
        patient.ifPresent(p -> model.addAttribute("patient", p));
        return "status";
    }
}









