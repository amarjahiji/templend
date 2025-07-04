package io.templend.serviceImpl;

import io.templend.model.Review;
import io.templend.query.ReviewSQL;
import io.templend.service.ReviewService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewServiceImpl extends AbstractServiceImpl implements ReviewService {

    @Override
    public Review getById(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ReviewSQL.GET_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Review(rs);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Review> getForItem(String id) throws Exception {
        List<Review> reviews = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ReviewSQL.GET_FOR_ITEM);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return reviews;
    }

    @Override
    public List<Review> getForOwner(String id) throws Exception {
        List<Review> reviews = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ReviewSQL.GET_FOR_OWNER);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return reviews;
    }

    @Override
    public Review save(Review review) throws Exception {
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(ReviewSQL.SAVE);
            review.populatePs(ps);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return getById(review.getId());
    }

    @Override
    public Float getAverageItemRating(List<Review> reviews) throws Exception {
        Float sum = 0F;
        for (Review review : reviews) {
            sum += review.getItemRating();
        }
        return sum / reviews.size();
    }

    @Override
    public Float getAverageUserRating(List<Review> reviews) throws Exception {
        Float sum = 0F;
        for (Review review : reviews) {
            sum += review.getUserRating();
        }
        return sum / reviews.size();
    }
}
