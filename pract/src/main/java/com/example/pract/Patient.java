package com.example.pract;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

// Этот класс отвечает за Patient (логично)

@Entity
public class Patient {

    @Id
    private String id;
    private String name;
    private String gender;
    private LocalDateTime birthDate;

    public Patient() {
    }

    public Patient(String id, String name, String gender, LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
