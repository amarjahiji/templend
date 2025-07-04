package io.templend.serviceImpl;

import io.templend.model.*;
import io.templend.query.CommentSQL;
import io.templend.query.PostSQL;
import io.templend.query.ReviewSQL;
import io.templend.service.CommentService;
import io.templend.service.PostService;
import io.templend.service.ReviewService;
import io.templend.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostServiceImpl extends AbstractServiceImpl implements PostService {
    private final ReviewService reviewService = new ReviewServiceImpl();
    private final CommentService commentService = new CommentServiceImpl();

    @Override
    public List<Post> get() throws Exception {
        Map<String, Post> postsByItem = new HashMap<>();
        List<Post> posts = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(PostSQL.GET_ITEM_USER_CATEGORY);
            rs = ps.executeQuery();
            while (rs.next()) {
                String itemId = rs.getString("i.id");
                postsByItem.putIfAbsent(itemId, new Post(new Item(rs), new User(rs), new Category(rs)));
            }
            String itemIds = "(" + String.join(",", postsByItem.keySet()) + ")";
            Map<String, List<Comment>> commentsByItemId = loadComments(connection, itemIds);
            Map<String, List<Review>> reviewsByItemId = loadReviews(connection, itemIds);
            for (Post post : postsByItem.values()) {
                Float averageItemRating = reviewService.getAverageItemRating(reviewsByItemId.getOrDefault(post.getItem().getId(), new ArrayList<>()));
                Float averageUserRating = reviewService.getAverageUserRating(reviewsByItemId.getOrDefault(post.getOwner().getId(), new ArrayList<>()));
                posts.add(new Post(post.getItem(),
                        post.getOwner(),
                        post.getCategory(),
                        commentsByItemId.getOrDefault(post.getItem().getId(), new ArrayList<>()),
                        reviewsByItemId.getOrDefault(post.getItem().getId(), new ArrayList<>()),
                        averageItemRating,
                        averageUserRating));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        return posts;
    }

    @Override
    public Post getByIdWithDetails(String id) throws Exception {
        Post post = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(PostSQL.GET_ITEM_USER_CATEGORY_BY_ITEM);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                post = (new Post(new Item(rs), new User(rs), new Category(rs), null, null, 0F, 0F));
            }
            if (post != null) {
                List<Comment> comments = commentService.getByItem(id);
                List<Review> reviews = reviewService.getForItem(id);
                post.setComments(comments);
                post.setReviews(reviews);
                post.setItemRating(reviewService.getAverageItemRating(reviews));
                post.setUserRating(reviewService.getAverageUserRating(reviews));
                return post;
            } else {
                return null;
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
    }

    @Override
    public Post getByIdWithoutDetails(String id) throws Exception {
        Post post = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = DatabaseConnector.getConnection();
        try {
            ps = connection.prepareStatement(PostSQL.GET_ITEM_USER_CATEGORY_BY_ITEM);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                post = new Post(new Item(rs), new User(rs), new Category(rs), 0F, 0F);
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(connection);
        }
        List<Review> reviews = reviewService.getForItem(id);
        if (post != null) {
            post.setItemRating(reviewService.getAverageItemRating(reviews));
            post.setUserRating(reviewService.getAverageUserRating(reviews));
            return post;
        } else {
            return null;
        }
    }

    private Map<String, List<Comment>> loadComments(Connection connection, String itemIds) throws Exception {
        Map<String, List<Comment>> commentsByItem = new HashMap<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(CommentSQL.GET_BY_ITEMS);
            ps.setString(1, itemIds);
            rs = ps.executeQuery();
            while (rs.next()) {
                String itemId = rs.getString("item_id");
                commentsByItem.computeIfAbsent(itemId, k -> new ArrayList<>()).add(new Comment(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return commentsByItem;
    }

    private Map<String, List<Review>> loadReviews(Connection connection, String itemIds) throws Exception {
        Map<String, List<Review>> reviewsByItem = new HashMap<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(ReviewSQL.GET_BY_ITEMS);
            ps.setString(1, itemIds);
            rs = ps.executeQuery();
            while (rs.next()) {
                String itemId = rs.getString("item_id");
                reviewsByItem.computeIfAbsent(itemId, k -> new ArrayList<>()).add(new Review(rs));
            }
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
        }
        return reviewsByItem;
    }
}