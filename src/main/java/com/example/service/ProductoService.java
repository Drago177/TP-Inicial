package com.example.service;

import com.example.domain.Producto;
import java.util.List;

public interface ProductoService {
    public List<Producto> listarProductos();

    public void guardar(Producto producto);

    public void eliminar(Producto producto);

    public Producto encontrarProducto(Producto producto);

    public Producto encontrarProductoPorId(Long id);
}