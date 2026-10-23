package com.techlab.ejercicios_practicos_backend_java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/hello")
public class HelloController {
    @GetMapping 
    public String saludar() {
        return "¡Hola Mundo desde Spring Boot en TechLab!";
    }
}
