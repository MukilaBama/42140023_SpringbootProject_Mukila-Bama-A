package com.clinic.appointment.controller;

import com.clinic.appointment.model.Patient;
import com.clinic.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/admin/search")
    public String showSearchForm() {
        return "admin-search";
    }

    @PostMapping("/admin/search")
    public String searchPatients(@RequestParam String name, Model model) {
        List<Patient> results = patientService.searchByName(name);
        model.addAttribute("results", results);
        return "result";
    }

    @PostMapping("/admin/update-status")
    public String updateStatus(@RequestParam Long id, @RequestParam boolean metDoctor) {
        patientService.updatePatientStatus(id, metDoctor);
        return "redirect:/admin/search";
    }
}

