package io.templend.service;

import io.templend.model.Review;

import java.util.List;

public interface ReviewService {
    Review getById(String id) throws Exception;

    List<Review> getForItem(String id) throws Exception;

    List<Review> getForOwner(String id) throws Exception;

    Review save(Review review) throws Exception;

    Float getAverageItemRating(List<Review> reviews) throws Exception;

    Float getAverageUserRating(List<Review> reviews) throws Exception;
}
