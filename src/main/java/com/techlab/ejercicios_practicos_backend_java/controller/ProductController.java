package com.techlab.ejercicios_practicos_backend_java.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.techlab.ejercicios_practicos_backend_java.model.Producto;
import com.techlab.ejercicios_practicos_backend_java.service.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productService.listarTodos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable int id) {
        return productService.obtenerPorId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto nuevoProducto) {
        return productService.guardar(nuevoProducto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto datosActualizados) {
        return productService.actualizar(id, datosActualizados);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id) {
        boolean eliminado = productService.eliminar(id);
        if (eliminado) {
            return "Producto con ID " + id + " eliminado correctamente.";
        } else {
            return "Producto con ID " + id + " no encontrado.";
        }
    }
}
