package com.techlab.ejercicios_practicos_backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techlab.ejercicios_practicos_backend_java.model.Producto;
import com.techlab.ejercicios_practicos_backend_java.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public Producto obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    public Producto actualizar(int id, Producto datos) {
        Producto p = obtenerPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getStock());
            p.setDescripcion(datos.getDescripcion());
            p.setCategoria(datos.getCategoria());
            return repo.save(p);
        }
        return null;
    }

    public boolean eliminar(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
}
