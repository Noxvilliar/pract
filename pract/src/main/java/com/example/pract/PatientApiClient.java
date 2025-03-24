package com.example.pract;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

// Консолька для отправки 100 челов через API

public class PatientApiClient {

    private static final String API_URL = "http://localhost:8080/patients"; // URL вашего API

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        List<Patient> patients = PatientGenerator.generatePatients(100); // Генерация 100 пациентов

        for (Patient patient : patients) {
            HttpEntity<Patient> request = new HttpEntity<>(patient);

            // Отправка POST запроса для каждого пациента
            ResponseEntity<Patient> response = restTemplate.exchange(
                    API_URL,
                    HttpMethod.POST,
                    request,
                    Patient.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Patient created: " + response.getBody().getName());
            } else {
                System.err.println("Failed to create patient: " + patient.getName());
            }
        }
    }
}
