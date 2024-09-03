package com.example.service;

import com.example.domain.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();

    void guardar(Producto producto);

    void eliminar(Producto producto);

    Producto encontrarProducto(Producto producto);

<<<<<<< HEAD
    Producto encontrarProductoPorId(Long id);
}
=======
    public Producto encontrarProductoPorId(Long id);
}
>>>>>>> ea6eec7d8d75ebafa5d4dc6992c4d2289e94de75
