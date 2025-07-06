package io.templend.serviceImpl;

import io.templend.model.BorrowRequest;
import io.templend.model.BorrowRequestDetail;
import io.templend.model.Item;
import io.templend.model.User;
import io.templend.query.BorrowRequestDetailSQL;
import io.templend.service.BorrowRequestDetailService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BorrowRequestDetailServiceImpl extends AbstractServiceImpl implements BorrowRequestDetailService {
    @Override
    public List<BorrowRequestDetail> getPendingByLender(String lenderId) throws Exception {
        List<BorrowRequestDetail> borrowRequestDetails = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(BorrowRequestDetailSQL.GET_PENDING_BY_LENDER);
            ps.setString(1, lenderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs);
                User user = new User(rs);
                BorrowRequest borrowRequest = new BorrowRequest(rs);
                BorrowRequestDetail requestDetail = new BorrowRequestDetail();
                requestDetail.setItem(item);
                requestDetail.setBorrower(user);
                requestDetail.setRequest(borrowRequest);
                borrowRequestDetails.add(requestDetail);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return borrowRequestDetails;
    }

    @Override
    public List<BorrowRequestDetail> getByLendersItem(String lenderId, String itemId) throws Exception {
        List<BorrowRequestDetail> borrowRequestDetails = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(BorrowRequestDetailSQL.GET_PENDING_BY_LENDERS_ITEM);
            ps.setString(1, lenderId);
            ps.setString(2, itemId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs);
                User user = new User(rs);
                BorrowRequest borrowRequest = new BorrowRequest(rs);
                BorrowRequestDetail requestDetail = new BorrowRequestDetail();
                requestDetail.setItem(item);
                requestDetail.setBorrower(user);
                requestDetail.setRequest(borrowRequest);
                borrowRequestDetails.add(requestDetail);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return borrowRequestDetails;
    }

    @Override
    public List<BorrowRequestDetail> getByBorrower(String borrower_id) throws Exception {
        List<BorrowRequestDetail> borrowRequestDetails = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(BorrowRequestDetailSQL.GET_BY_BORROWER);
            ps.setString(1, borrower_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs);
                User user = new User(rs);
                BorrowRequest borrowRequest = new BorrowRequest(rs);
                BorrowRequestDetail requestDetail = new BorrowRequestDetail();
                requestDetail.setItem(item);
                requestDetail.setBorrower(user);
                requestDetail.setRequest(borrowRequest);
                borrowRequestDetails.add(requestDetail);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return borrowRequestDetails;
    }
}
