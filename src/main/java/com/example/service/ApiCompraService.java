package com.example.service;

import com.example.domain.Compra;
import com.example.domain.Producto;

public interface ApiCompraService {
    Double pedirCostos(Producto producto);
    String comprar(Compra compra);
}
