package io.templend.serviceImpl;

import io.templend.model.BorrowRequest;
import io.templend.query.BorrowRequestSQL;
import io.templend.service.BorrowRequestService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BorrowRequestServiceImpl extends AbstractServiceImpl implements BorrowRequestService {

    @Override
    public void requestOrResponse(BorrowRequest borrowRequest) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(BorrowRequestSQL.SAVE);
            borrowRequest.populatePs(ps);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
    }
}
