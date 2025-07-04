package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("item")
    private Item item;
    @SerializedName("owner")
    private User owner;
    @SerializedName("category")
    private Category category;
    @SerializedName("comments")
    private List<Comment> comments;
    @SerializedName("reviews")
    private List<Review> reviews;
    @SerializedName("item_rating")
    private Float itemRating;
    @SerializedName("user_rating")
    private Float userRating;

    public Post(Item item, User owner, Category category, List<Comment> comments, List<Review> reviews, Float itemRating, Float userRating) {
        this.item = item;
        this.owner = owner;
        this.category = category;
        this.comments = comments;
        this.reviews = reviews;
        this.itemRating = itemRating;
        this.userRating = userRating;
    }

    public Post(Item item, User owner, Category category, List<Review> reviews) {
        this.item = item;
        this.owner = owner;
        this.category = category;
        this.reviews = reviews;
    }

    public Post(Item item, User owner, Category category) {
        this.item = item;
        this.owner = owner;
        this.category = category;
    }

    public Post(Item item, User owner, Category category, Float itemRating, Float userRating) {
        this.item = item;
        this.owner = owner;
        this.category = category;
        this.itemRating = itemRating;
        this.userRating = userRating;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Float getItemRating() {
        return itemRating;
    }

    public void setItemRating(Float itemRating) {
        this.itemRating = itemRating;
    }

    public Float getUserRating() {
        return userRating;
    }

    public void setUserRating(Float userRating) {
        this.userRating = userRating;
    }
}
