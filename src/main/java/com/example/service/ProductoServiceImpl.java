package com.example.service;

import com.example.dao.ProductoDao;
import com.example.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
        return productoDao.findById(producto.getId()).orElse(null);
    }

    @Override
    public Producto encontrarProductoPorId(Long id) {
        return productoDao.findById(id).orElse(null);
    }
/*
    @Scheduled(fixedRate = 3600000)
    private void revisarStock() {
        double margen = 40;
        List<Producto> productos = listarProductos();
        for(Producto producto : productos)
            if(producto.getStock() <= 50) {
                Compra compra = new Compra(producto.getNombre(), margen);
                comprar(compra);
            }

    }

    private boolean comprar(Producto producto) {
        if (revisarCostos(producto))
            return comprarApi();

        return false;
    }

    private boolean comprarApi() {
        //petición de compra a la api
        return false;
    }

    private boolean revisarCostos(Producto producto) {
        double costosAceptables = 0;
        if (pedirCostosApi(producto) <= costosAceptables)
            return true;
        return false;
    }

    private double pedirCostosApi(Producto producto) {
        //pide los costos de la compra a la api
        return 0;
    }

 */
}
