package io.templend.serviceImpl;

import io.templend.model.Category;
import io.templend.model.Item;
import io.templend.query.CategorySQL;
import io.templend.service.CategoryService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryServiceImpl extends AbstractServiceImpl implements CategoryService {

    @Override
    public List<Category> get() throws Exception {
        List<Category> categories = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CategorySQL.GET);
            rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return categories;
    }

    @Override
    public Category getById(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CategorySQL.GET_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(rs);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public Category save(Category category) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CategorySQL.SAVE);
            category.populatePs(ps);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return getById(category.getId());
    }

    @Override
    public List<Category> getWithItems() throws Exception {
        List<Category> categories = get();
        List<String> categoriesIds = categories.stream().map(Category::getId).collect(Collectors.toList());
        Map<String, List<Item>> itemsByCategoryIds = new ItemServiceImpl().getItemsByCategoryIds(categoriesIds);
        for (Category category : categories) {
            category.setItems(itemsByCategoryIds.getOrDefault(category.getId(), new ArrayList<>()));
        }
        return categories;
    }

    @Override
    public Category getWithItemsByName(String name) throws Exception {
        Category category = getByName(name);
        if (category == null) {
            return null;
        }
        List<Item> items = new ItemServiceImpl().getByCategoryId(category.getId());
        if (items != null) {
            category.setItems(items);
        }
        return category;
    }

    private Category getByName(String name) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CategorySQL.GET_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(rs);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Category> getByIds(Set<String> ids) throws Exception {
        List<Category> categories = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CategorySQL.GET_BY_IDS);
            ps.setString(1, "(" + String.join(",", ids) + ")");
            rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return categories;
    }
}