package io.templend.serviceImpl;

import io.templend.model.Comment;
import io.templend.query.CommentSQL;
import io.templend.service.CommentService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl extends AbstractServiceImpl implements CommentService {

    @Override
    public Comment getById(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CommentSQL.GET_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Comment(rs);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return null;
    }

    @Override
    public List<Comment> getByItem(String itemId) throws Exception {
        List<Comment> comments = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CommentSQL.GET_BY_ITEM);
            ps.setString(1, itemId);
            rs = ps.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return comments;
    }

    @Override
    public List<Comment> getSubcommentsByParentId(String id) throws Exception {
        List<Comment> comments = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(CommentSQL.GET_BY_PARENT_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return comments;
    }

    @Override
    public Comment save(Comment comment) throws Exception{
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try{
            ps = connection.prepareStatement(CommentSQL.SAVE);
            comment.populatePs(ps);
            ps.executeUpdate();
        } finally {
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return getById(comment.getId());
    }

}
