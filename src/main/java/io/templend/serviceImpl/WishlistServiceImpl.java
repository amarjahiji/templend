package io.templend.serviceImpl;

import io.templend.model.Item;
import io.templend.query.WishlistSQL;
import io.templend.service.WishlistService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WishlistServiceImpl extends AbstractServiceImpl implements WishlistService {
    @Override
    public List<Item> get(String userId) throws Exception {
        List<Item> items = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(WishlistSQL.GET_BY_USER);
            ps.setString(1, userId);
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
    public List<Item> create(String userId, String itemId) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(WishlistSQL.CREATE);
            ps.setString(1, userId);
            ps.setString(2, itemId);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return get(userId);
    }
}
