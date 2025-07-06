package com.clinic.appointment.service;

import com.clinic.appointment.model.Patient;
import com.clinic.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // ✅ Only count patients who haven't met the doctor
    public int getWaitlistCount(String slot) {
        return patientRepository.countBySlotAndAppointmentDateAndMetDoctorFalse(slot, LocalDate.now());
    }

    public Patient registerPatient(Patient patient) {
        int waitlistCount = getWaitlistCount(patient.getSlot());
        patient.setWaitlistNumber(waitlistCount + 1);
        patient.setAppointmentDate(LocalDate.now());
        patient.setMetDoctor(false); // default to false
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientStatus(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> searchByName(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    public void updatePatientStatus(Long id, boolean metDoctor) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        optionalPatient.ifPresent(patient -> {
            patient.setMetDoctor(metDoctor);
            patientRepository.save(patient);
        });
    }
}


