package com.example.controller;

import com.example.domain.Producto;
import com.example.service.MovimientoService;
import com.example.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "https://gestionstock-tplabo.netlify.app")
@RestController
@RequestMapping("productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @Autowired
    MovimientoService movimientoService;

    @GetMapping()
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @PostMapping()
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoActual = productoService.encontrarProductoPorId(id);
        if(productoActual == null)
            return ResponseEntity.notFound().build();
        int stockResult = productoActual.getStock() + producto.getStock();
        if(stockResult < 0)
            return ResponseEntity.badRequest().body(producto);
        /*
            lógica de compra automática
         */
        productoActual.setStock(stockResult);
        Producto productoUPD = productoService.guardar(productoActual);
        movimientoService.guardarMovimiento(productoUPD, producto.getStock());
        return ResponseEntity.ok(productoUPD);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        Producto producto = productoService.encontrarProductoPorId(id);
        productoService.eliminar(producto);
        if(productoService.encontrarProductoPorId(id) == null) {
            return "Producto eliminado";
        }
        return "Error al eliminar";
    }

    @GetMapping("/{id}")
    public Producto encontrarProducto(@PathVariable Long id){
        return productoService.encontrarProductoPorId(id);
    }
}
