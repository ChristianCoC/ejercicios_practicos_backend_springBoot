package com.techlab.ejercicios_practicos_backend_java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.ejercicios_practicos_backend_java.model.Producto;
import com.techlab.ejercicios_practicos_backend_java.service.ProductoService;

@RestController 
@RequestMapping ("/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired 
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping 
    public List<Producto> listarProductos() {
        return productoService.obtenerProductos();
    }
}
