package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Comment extends AbstractModel {
    @SerializedName("text")
    String text;
    @SerializedName("user_id")
    String userId;
    @SerializedName("item_id")
    String itemId;
    @SerializedName("parent_comment_id")
    String parentCommentId;
    @SerializedName("subcomments")
    List<Comment> subComments;

    @Override
    public String validate() {
        return null;
    }

    public Comment(ResultSet rs) throws Exception {
        setId(rs.getString("id"));
        setText(rs.getString("text"));
        setUserId(rs.getString("user_id"));
        setItemId(rs.getString("item_id"));
        setParentCommentId(rs.getString("parent_comment_id"));
    }

    public void populatePs(PreparedStatement ps) throws Exception {
        ps.setString(1, getId());
        ps.setString(2, getText());
        ps.setString(3, getUserId());
        ps.setString(4, getItemId());
        ps.setString(5, getParentCommentId());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public List<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
}
