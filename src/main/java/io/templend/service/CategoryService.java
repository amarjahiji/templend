package io.templend.service;

import io.templend.model.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<Category> get() throws Exception;

    Category getById(String id) throws Exception;

    Category save(Category category) throws Exception;

    List<Category> getWithItems() throws Exception;

    Category getWithItemsByName(String name) throws Exception;

    List<Category> getByIds(Set<String> ids) throws Exception;
}