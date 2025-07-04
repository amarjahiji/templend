package io.templend.serviceImpl;

import io.templend.model.User;
import io.templend.query.UserSQL;
import io.templend.service.UserService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserServiceImpl extends AbstractServiceImpl implements UserService {
    public List<User> get() throws Exception {
        List<User> users = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(UserSQL.GET);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return users;
    }

    public User getById(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(UserSQL.GET_BY_ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return null;
    }

    public User save(User user) throws Exception {
        validateUser(user);
        checkUniqueness(user);
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(UserSQL.SAVE);
            user.populatePs(ps);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return getById(user.getId());
    }

    @Override
    public String delete(String id) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(UserSQL.DELETE_BY_ID);
            ps.setString(1, id);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return "{\"message\": \"Deleted successfully\"}";
    }

    @Override
    public String login(User user) throws Exception {
        validateUser(user);
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(UserSQL.GET_BY_USERNAME_EMAIL_PHONE_AND_PASSWORD);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("{\"message\": \"Deleted successfully\"}");
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return null;
    }

    private void checkUniqueness(User user) throws Exception {
        validateUser(user);
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        String id = null;
        try {
            ps = connection.prepareStatement(UserSQL.GET_ID_BY_USERNAME_EMAIL_PHONE);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getString("id");
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        if (id != null && !id.equals(user.getId())) {
            throw new Exception("User Already Exists with that username/email/phone-number.");
        }
    }

    @Override
    public List<User> getByIds(Set<String> ids) throws Exception {
        List<User> users = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(UserSQL.GET_BY_IDS);
            ps.setString(1, "(" + String.join(",", ids) + ")");
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return users;
    }
}
