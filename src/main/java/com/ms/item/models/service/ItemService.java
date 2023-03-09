package com.ms.item.models.service;

import java.util.List;

import com.ms.item.models.entity.Item;

public interface ItemService {

    List<Item> findAll();

    Item findById(Long id, Integer cantidad);
}
