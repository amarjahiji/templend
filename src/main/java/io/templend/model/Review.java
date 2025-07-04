package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.sql.ResultSet;

public class Review extends AbstractModel {

    @SerializedName("item_rating")
    Integer itemRating;
    @SerializedName("user_rating")
    Integer userRating;
    @SerializedName("item_comment")
    String itemComment;
    @SerializedName("owner_comment")
    String ownerComment;
    @SerializedName("user_id")
    String userId;
    @SerializedName("owner_id")
    String ownerId;
    @SerializedName("item_id")
    String itemId;

    @Override
    public String validate() {
        return null;
    }

    public Review(ResultSet rs) throws Exception {
        setId(rs.getString("id"));
        setItemRating(rs.getInt("item_rating"));
        setUserRating(rs.getInt("user_rating"));
        setItemComment(rs.getString("review_comment"));
        setUserId(rs.getString("user_id"));
        setItemId(rs.getString("item_id"));
        setCreatedAt(rs.getString("updated_at"));
    }

    public void populatePs(java.sql.PreparedStatement ps) throws Exception {
        ps.setString(1, getId());
        ps.setInt(2, getItemRating());
        ps.setInt(3, getUserRating());
        ps.setString(4, getItemComment());
        ps.setString(5, getUserId());
        ps.setString(6, getItemId());
        ps.setString(7, getOwnerComment());
        ps.setString(8, getOwnerId());

    }

    public Integer getItemRating() {
        return itemRating;
    }

    public void setItemRating(Integer itemRating) {
        this.itemRating = itemRating;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public String getItemComment() {
        return itemComment;
    }

    public void setItemComment(String itemComment) {
        this.itemComment = itemComment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOwnerComment() {
        return ownerComment;
    }

    public void setOwnerComment(String ownerComment) {
        this.ownerComment = ownerComment;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
