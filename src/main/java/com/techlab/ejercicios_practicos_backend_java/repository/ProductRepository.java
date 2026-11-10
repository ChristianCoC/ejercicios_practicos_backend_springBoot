package com.techlab.ejercicios_practicos_backend_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techlab.ejercicios_practicos_backend_java.model.Producto;

@Repository 
public interface ProductRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombre(String nombre);
}
