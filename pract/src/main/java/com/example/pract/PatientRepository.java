package com.example.pract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// хз, но в теории должен хранить репозы для работы с данными

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
}
