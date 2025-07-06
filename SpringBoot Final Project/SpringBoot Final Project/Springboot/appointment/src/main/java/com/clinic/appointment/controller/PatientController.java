package com.clinic.appointment.controller;

import com.clinic.appointment.model.Patient;
import com.clinic.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String registerPatient(@ModelAttribute Patient patient, Model model) {
        // ✅ Save patient
        Patient savedPatient = patientService.registerPatient(patient);
        model.addAttribute("patient", savedPatient);

        // ✅ Get waitlist counts
        int morningCount = patientService.getWaitlistCount("morning");
        int eveningCount = patientService.getWaitlistCount("evening");

        // ✅ Add to model
        model.addAttribute("morningCount", morningCount);
        model.addAttribute("eveningCount", eveningCount);
        model.addAttribute("selectedSlot", savedPatient.getSlot());

        // ✅ Redirect to waitlist-status page
        return "waitlist-status";
    }

    @GetMapping("/waitlist")
    public String checkWaitlist(@RequestParam String slot, Model model) {
        // ✅ Show both counts for clarity
        int morningCount = patientService.getWaitlistCount("morning");
        int eveningCount = patientService.getWaitlistCount("evening");

        model.addAttribute("morningCount", morningCount);
        model.addAttribute("eveningCount", eveningCount);
        model.addAttribute("selectedSlot", slot);

        return "waitlist-status";
    }

    @GetMapping("/status")
    public String viewStatusForm() {
        return "status";
    }
}

