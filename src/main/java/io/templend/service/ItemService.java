package io.templend.service;

import io.templend.model.Item;
import io.templend.model.Post;

import java.util.List;
import java.util.Map;

public interface ItemService {
    List<Item> get() throws Exception;

    Item getById(String id) throws Exception;

    List<Item> getByOwnerId(String ownerId) throws Exception;

    Item save(Item item) throws Exception;

    String delete(String id) throws Exception;

    Map<String, Object> getPaginated(int page, int size) throws Exception;

    List<Item> getByKeyword(String keyword) throws Exception;

    List<Item> getByAvailability(boolean available) throws Exception;

    Map<String, List<Item>> getItemsByCategoryIds(List<String> categoryIds) throws Exception;

    List<Item> getByCategoryId(String id) throws Exception;

    Post getWithDetailsById(String id) throws Exception;
}
