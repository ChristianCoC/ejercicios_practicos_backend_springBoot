package com.techlab.ejercicios_practicos_backend_java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.techlab.ejercicios_practicos_backend_java.model.Producto;

@Service 
public class ProductService {

    private final List<Producto> productos = new ArrayList<>();
    private int contadorId = 1;

    public ProductService() {
        guardar(new Producto(0, "Café Espreo", 2500.0, 50));
        guardar(new Producto(1, "Te Verde", 1800.0, 30));
        guardar(new Producto(2, "Alfajor Artesanal", 1200.0, 100));
    }

    public List<Producto> listarTodos() {
        return productos;
    }

    public Producto obtenerPorId(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() != null && producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Producto guardar(Producto p) {
        p.setId(contadorId++);
        productos.add(p);
        return p;
    }

    public Producto actualizar(int id, Producto datos) {
        Producto p = obtenerPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getStock());
        }
        return p;
    }

    public boolean eliminar(int id) {
        return productos.removeIf(p -> p.getId() != null && p.getId() == id);
    }
}
