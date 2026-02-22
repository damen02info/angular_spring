package com.mdz.angular_spring.controller;

import com.mdz.angular_spring.model.Producto;
import com.mdz.angular_spring.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api") // http://localhost:8080/api
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde el frontend Angular (puerto 4200)
public class ProductoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
    private final ProductoService productoService;

    @GetMapping("/productos") // http://localhost:8080/api/productos
    public List<Producto> obtenerProductos() {
        logger.info("--- Obteniendo lista de productos ---");
        List<Producto> productos = productoService.listarProductos();
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos") // http://localhost:8080/api/productos
    public Producto agregarProducto(@RequestBody Producto producto) {
        logger.info("--- Agregando nuevo producto ---");
        logger.info(producto.toString());
        return this.productoService.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}") // http://localhost:8080/api/productos/1
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id) {
        logger.info("--- Obteniendo producto por ID: {} ---", id);
        Producto producto = this.productoService.buscarProductoPorId(id);
        if (producto != null) {
            logger.info(producto.toString());
            return ResponseEntity.ok(producto);
        } else {
            logger.warn("Producto con ID {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/productos/{id}") // http://localhost:8080/api/productos/1
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido) {
        logger.info("--- Actualizando producto con ID: {} ---", id);
        logger.info(productoRecibido.toString());
        Producto productoActualizar = this.productoService.buscarProductoPorId(id);
        productoActualizar.setDescripcion(productoRecibido.getDescripcion());
        productoActualizar.setPrecio(productoRecibido.getPrecio());
        productoActualizar.setExistencia(productoRecibido.getExistencia());

        productoService.guardarProducto(productoActualizar);
        logger.info("Producto actualizado: {}", productoActualizar);
        return ResponseEntity.ok(productoActualizar);
    }
}