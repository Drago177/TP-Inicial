package com.example.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "fecha_y_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "costo_total", nullable = false)
    private double costoTotal;

    private String tipoMovimiento;
}
