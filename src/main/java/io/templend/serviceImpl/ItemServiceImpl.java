package io.templend.serviceImpl;

import io.templend.model.item.Item;
import io.templend.query.ItemSQL;
import io.templend.service.ItemService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ItemServiceImpl extends AbstractServiceImpl implements ItemService {
    @Override
    public List<Item> get() throws Exception {
        List<Item> items = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ItemSQL.GET);
            rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new Item(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return items;
    }

    @Override
    public Item getById(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ItemSQL.GET);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Item(rs);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Item> getByOwnerId(String ownerId) throws Exception {
        List<Item> items = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ItemSQL.GET_BY_OWNER_ID);
            ps.setString(1, ownerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new Item(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return items;
    }

    @Override
    public Item save(Item item) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ItemSQL.SAVE);
            item.populatePs(ps);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return getById(item.getId());
    }

    @Override
    public String delete(String id) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ItemSQL.DELETE_BY_ID);
            ps.setString(1, id);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return "{\"message\": \"Deleted successfully\"}";
    }

    @Override
    public Map<String, Object> getPaginated(int page, int size) throws Exception {
        List<Item> items = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        ResultSet countRs = null;
        ResultSet paginationRs = null;
        PreparedStatement countPs = null;
        PreparedStatement paginationPs = null;
        Integer totalItems = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            countPs = connection.prepareStatement(ItemSQL.COUNT);
            countRs = countPs.executeQuery();
            if (countRs.next()) {
                totalItems = countRs.getInt(1);
            }
            paginationPs = connection.prepareStatement(ItemSQL.PAGINATION);
            paginationPs.setInt(1, size);
            paginationPs.setInt(2, (page - 1) * size);
            paginationRs = paginationPs.executeQuery();
            while (paginationRs.next()) {
                items.add(new Item(paginationRs));
            }
        } finally {
            closeResultSet((ResultSet) Arrays.asList(countRs, paginationRs));
            closePreparedStatement((PreparedStatement) Arrays.asList(countPs, paginationPs));
            closeConnection(connection);
        }
        response.put("items", items);
        response.put("totalItems", totalItems);
        response.put("totalPages", (int) Math.ceil((double) totalItems / size));
        response.put("currentPage", page);

        return response;
    }
}