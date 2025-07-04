package io.templend.service;

import io.templend.model.Post;

import java.util.List;

public interface PostService {
    List<Post> get() throws Exception;

    Post getByIdWithDetails(String id) throws Exception;

    Post getByIdWithoutDetails(String id) throws Exception;
}
