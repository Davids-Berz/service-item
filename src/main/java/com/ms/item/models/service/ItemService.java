package com.ms.item.models.service;

import java.util.List;

import com.ms.item.models.entity.Item;

public interface ItemService {

    public List<Item> findAll();

    public Item findId(Long id, Integer cantidad);
}
