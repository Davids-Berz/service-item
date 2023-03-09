package com.ms.item.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ms.item.models.entity.Item;

public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRestTemplate;

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findId(Long id, Integer cantidad) {
        return null;
    }

}
