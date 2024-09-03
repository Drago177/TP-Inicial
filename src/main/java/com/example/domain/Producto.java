package com.example.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {
        private static final long serialVersionUID = 1L;

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private String marca;
=======
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idProducto;

        private String nombre;
>>>>>>> ea6eec7d8d75ebafa5d4dc6992c4d2289e94de75

        private int stock;

    private double costo;
}
