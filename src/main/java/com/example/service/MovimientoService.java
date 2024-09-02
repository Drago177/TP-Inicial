package com.example.service;

import com.example.domain.Movimiento;
import java.util.List;

public interface MovimientoService {
    List<Movimiento> obtenerTodos();

    Movimiento guardarMovimiento(Movimiento movimiento);

    Movimiento obtenerPorId(Long id);

    boolean eliminarMovimiento(Long id);
}