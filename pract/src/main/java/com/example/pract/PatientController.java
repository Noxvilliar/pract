package com.example.pract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Данный класс в ответе за CRUD-операции

// обычный класс
/*
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Получить всех пациентов
    @GetMapping
    @PreAuthorize("hasAuthority('Patient.Read')")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Получить пациента по ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Patient.Read')")
    public Patient getPatientById(@PathVariable String id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    // Создать нового пациента
    @PostMapping
    @PreAuthorize("hasAuthority('Patient.Write')")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // Обновить пациента
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Patient.Write')")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id " + id);
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

    // Удалить пациента
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Patient.Delete')")
    public void deletePatient(@PathVariable String id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id " + id);
        }
        patientRepository.deleteById(id);
    }
}
*/

//обновлённый со сваггером для описания API:


@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Operation(summary = "Get all patients", description = "Retrieve a list of all patients.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of patients"),
        @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @GetMapping
    @PreAuthorize("hasAuthority('Patient.Read')")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Operation(summary = "Get a patient by ID", description = "Retrieve a patient by their ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the patient"),
        @ApiResponse(responseCode = "404", description = "Patient not found"),
        @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Patient.Read')")
    public Patient getPatientById(@Parameter(description = "ID of the patient to be retrieved") @PathVariable String id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    @Operation(summary = "Create a new patient", description = "Create a new patient record.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created the patient"),
        @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping
    @PreAuthorize("hasAuthority('Patient.Write')")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @Operation(summary = "Update a patient", description = "Update the information of an existing patient.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated the patient"),
        @ApiResponse(responseCode = "404", description = "Patient not found"),
        @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Patient.Write')")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id " + id);
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

    @Operation(summary = "Delete a patient", description = "Delete an existing patient record.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted the patient"),
        @ApiResponse(responseCode = "404", description = "Patient not found"),
        @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Patient.Delete')")
    public void deletePatient(@PathVariable String id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id " + id);
        }
        patientRepository.deleteById(id);
    }
}
