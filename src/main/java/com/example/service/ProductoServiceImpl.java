package com.example.service;

import com.example.dao.ProductoDao;
import com.example.domain.Configuracion;
import com.example.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private ApiCompraService apiCompraService;

    @Autowired
    private ConfiguracionService configuracionService;

    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        //compraAutomatica(producto);
        return productoDao.save(producto);
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

    //Compra automática

    private void compraAutomatica(Producto producto) {
        Configuracion config = configuracionService.darPrimeraConfiguracion();
        if(producto.getStock() <= config.getStockMin()) {
            Double costos = apiCompraService.pedirCostos(producto);

        }
    }
}
