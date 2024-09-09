package com.example.service;

import com.example.domain.Compra;
import com.example.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiCompraServiceImpl implements ApiCompraService{
    @Value("${base-url}")
    protected String baseUrl;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Double pedirCostos(Producto producto) {
        return restTemplate.getForObject(baseUrl + "?tipoProducto=" + producto.getTipo() + "&marca=" + producto.getMarca(), Double.class);
    }

    @Override
    public String comprar(Compra compra) {
        return restTemplate.postForObject(baseUrl, compra, String.class);
    }
}
