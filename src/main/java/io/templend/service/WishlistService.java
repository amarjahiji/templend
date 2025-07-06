package io.templend.service;

import io.templend.model.Item;

import java.util.List;

public interface WishlistService {
    List<Item> get(String userId) throws Exception;

    List<Item> create(String userId, String itemId) throws Exception;
}
