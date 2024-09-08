package com.example.controller;

import com.example.domain.Movimiento;
import com.example.domain.Producto;
import com.example.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> listarMovimientos() {
        return movimientoService.obtenerTodos();
    }

    public Movimiento crearMovimiento(Producto producto, int cantidad) {
        return movimientoService.guardarMovimiento(producto, cantidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> encontrarMovimiento(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.obtenerPorId(id);
        if (movimiento != null) {
            return ResponseEntity.ok(movimiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMovimiento(@PathVariable Long id) {
        boolean eliminado = movimientoService.eliminarMovimiento(id);
        if (eliminado) {
            return ResponseEntity.ok("Movimiento eliminado");
        } else {
            return ResponseEntity.status(404).body("Error al eliminar");
        }
    }
}
