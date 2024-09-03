package com.example.domain;

import com.example.service.ProductoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
public class MovimientoAux {
    @Autowired
    ProductoService productoService;

    private Long id;

    private String tipoProducto;

    private int cantidad;

    private LocalDateTime fechaHora;

    private double costoTotal;

    private String tipoMovimiento;

    public MovimientoAux(Movimiento movimiento){
        id = movimiento.getId();
        tipoProducto = productoService.encontrarProductoPorId(movimiento.getIdProducto()).getTipo();
        cantidad = movimiento.getCantidad();
        fechaHora = movimiento.getFechaHora();
        costoTotal = movimiento.getCostoTotal();
        tipoMovimiento = movimiento.getTipoMovimiento();
    }
}
