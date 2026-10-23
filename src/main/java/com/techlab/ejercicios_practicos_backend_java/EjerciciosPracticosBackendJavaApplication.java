package com.techlab.ejercicios_practicos_backend_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EjerciciosPracticosBackendJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosPracticosBackendJavaApplication.class, args);
	}

}
