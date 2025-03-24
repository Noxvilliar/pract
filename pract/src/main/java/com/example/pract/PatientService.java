package com.example.pract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Точно не припомню, для чего он здесь, вроде это первая попытка написать CRUD-методы

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(String id, Patient patient) {
        if (patientRepository.existsById(id)) {
            patient.setId(id);
            return patientRepository.save(patient);
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}

