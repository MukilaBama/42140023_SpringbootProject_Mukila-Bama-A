package com.clinic.appointment.repository;

import com.clinic.appointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findBySlotAndAppointmentDate(String slot, LocalDate date);

    List<Patient> findByNameContainingIgnoreCase(String name);
    Optional<Patient> findTopByNameOrderByIdDesc(String name);


    // ✅ Count patients who haven't met the doctor
    int countBySlotAndAppointmentDateAndMetDoctorFalse(String slot, LocalDate date);

    // ✅ Find patient by exact name (for view-status)
    Optional<Patient> findByNameIgnoreCase(String name);
}


