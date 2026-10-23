package com.techlab.ejercicios_practicos_backend_java.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.techlab.ejercicios_practicos_backend_java.model.Producto;

@Service 
public class ProductoService {
    public List<Producto> obtenerProductos() {
        return Arrays.asList(
            new Producto("Café Espreo", 2500.0, 50),
            new Producto("Te Verde", 1800.0, 30),
            new Producto("Alfajor Artesanal", 1200.0, 100)
        );
    }
}
