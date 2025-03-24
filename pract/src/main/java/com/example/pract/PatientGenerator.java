package com.example.pract;

import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Данный класс должен генерировать Patient

public class PatientGenerator {

    private static final Faker faker = new Faker();

    public static List<Patient> generatePatients(int count) {
        List<Patient> patients = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Patient patient = new Patient(
                    UUID.randomUUID().toString(),
                    faker.name().fullName(),
                    faker.options().option("male", "female"),
                    LocalDateTime.now().minusYears(faker.number().numberBetween(18, 80))
            );
            patients.add(patient);
        }
        return patients;
    }
}
