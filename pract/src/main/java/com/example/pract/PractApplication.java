package com.example.pract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Вот тут запуск приложения

@SpringBootApplication  // Аннотация для старта приложения
public class PractApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractApplication.class, args);  // Запуск приложения
	}
}
