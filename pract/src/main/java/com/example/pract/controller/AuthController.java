package com.example.pract.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Это публичный эндпоинт";
    }

    @GetMapping("/private")
    public String privateEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "Это приватный эндпоинт. Пользователь: " + jwt.getSubject();
    }
} 