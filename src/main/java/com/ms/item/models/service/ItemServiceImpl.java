package com.ms.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.item.models.Producto;
import com.ms.item.models.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRestTemplate;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays
                .asList(clienteRestTemplate.getForObject("http://localhost:8001/listar", Producto[].class));
        return productos
                .stream()
                .map(p -> new Item(p, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Producto producto =
                clienteRestTemplate.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }

}
