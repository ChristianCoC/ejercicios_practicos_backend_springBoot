package com.techlab.ejercicios_practicos_backend_java.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techlab.ejercicios_practicos_backend_java.model.Producto;
import com.techlab.ejercicios_practicos_backend_java.service.ProductService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) 
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(@RequestParam (required = false) String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            return ResponseEntity.ok(productService.buscarPorNombre(nombre));
        }
        return ResponseEntity.ok(productService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = productService.obtenerPorId(id);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(producto);

    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto nuevoProducto) {
        Producto creado = productService.guardar(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable int id, @RequestBody Producto datosActualizados) {
        Producto producto = productService.actualizar(id, datosActualizados);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        boolean eliminado = productService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Producto con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con ID " + id + " no encontrado.");
        }
    }
}
