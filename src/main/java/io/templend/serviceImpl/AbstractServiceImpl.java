package io.templend.serviceImpl;

import io.templend.model.user.User;
import jakarta.ws.rs.BadRequestException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractServiceImpl {
    protected void closePreparedStatement(PreparedStatement... preparedStatements) throws SQLException, SQLException {
        for (PreparedStatement preparedStatement : preparedStatements) {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        }
    }

    protected void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
    }

    protected void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void validateUser (User user) throws BadRequestException {
        String validate = user.validate();
        if (validate != null) {
            throw new BadRequestException(validate);
        }
    }
}
