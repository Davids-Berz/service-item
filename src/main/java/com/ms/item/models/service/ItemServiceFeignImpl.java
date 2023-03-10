package com.ms.item.models.service;

import com.ms.item.clientes.ProductoClienteRest;
import com.ms.item.models.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("clienteFeign")
public class ItemServiceFeignImpl implements ItemService {

    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Item> findAll() {
        return clienteFeign
                .listar()
                .stream()
                .map(producto -> new Item(producto, 1))
                .collect(Collectors.toList());

    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteFeign.detalle(id), cantidad);
    }
}
