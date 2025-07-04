package io.templend.service;

import io.templend.model.Comment;

import java.util.List;

public interface CommentService {
    Comment getById(String id) throws Exception;

    List<Comment> getByItem(String itemId) throws Exception;

    List<Comment> getSubcommentsByParentId(String id) throws Exception;

    Comment save(Comment comment) throws Exception;
}
