package com.example.service;

import com.example.dao.ProductoDao;
import com.example.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto encontrarProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public Producto encontrarProductoPorId(Long id) {
        return productoDao.findById(id).orElse(null);
    }
}
