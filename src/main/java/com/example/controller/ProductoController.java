package com.example.controller;

import com.example.domain.Producto;
import com.example.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("productos")
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @PostMapping("guardar")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        productoService.guardar(producto);
        Producto productoGuardado = productoService.encontrarProducto(producto);
        //movimientos de tipo entrada
        return ResponseEntity.ok(productoGuardado);
    }

    @PostMapping("eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        productoService.eliminar(productoService.encontrarProductoPorId(id));
        if(productoService.encontrarProductoPorId(id) == null)
            return "Producto eliminado";
        return "Error al eliminar";
    }

    @GetMapping("productos/{id}")
    public Producto encontrarProducto(@PathVariable Long id){
        return productoService.encontrarProductoPorId(id);
    }
}
