package io.templend.service;

import io.templend.model.item.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    List<Item> get() throws Exception;

    Item getById(String id) throws Exception;

    List<Item> getByOwnerId(String ownerId) throws Exception;

    Item save(Item item) throws Exception;

    String delete(String id) throws Exception;

    Map<String, Object> getPaginated(int page, int size) throws Exception;
}
