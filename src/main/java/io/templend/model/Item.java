package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Item extends AbstractModel {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("available")
    private Boolean available;
    @SerializedName("picture_1_url")
    private String picture1Url;
    @SerializedName("picture_2_url")
    private String picture2Url;
    @SerializedName("picture_3_url")
    private String picture3Url;
    @SerializedName("picture_4_url")
    private String picture4Url;
    @SerializedName("picture_5_url")
    private String picture5Url;
    @SerializedName("picture_6_url")
    private String picture6Url;
    @SerializedName("picture_7_url")
    private String picture7Url;
    @SerializedName("picture_8_url")
    private String picture8Url;
    @SerializedName("picture_9_url")
    private String picture9Url;
    @SerializedName("picture_10_url")
    private String picture10Url;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("category_id")
    private String categoryId;

    public Item(Item other) {
        this.title = other.title;
        this.description = other.description;
        this.available = other.available;
        this.picture1Url = other.picture1Url;
        this.picture2Url = other.picture2Url;
        this.picture3Url = other.picture3Url;
        this.picture4Url = other.picture4Url;
        this.picture5Url = other.picture5Url;
        this.picture6Url = other.picture6Url;
        this.picture7Url = other.picture7Url;
        this.picture8Url = other.picture8Url;
        this.picture9Url = other.picture9Url;
        this.picture10Url = other.picture10Url;
        this.ownerId = other.ownerId;
        this.categoryId = other.categoryId;
    }

    public Item(ResultSet rs) throws Exception {
        setId(rs.getString("id"));
        setTitle(rs.getString("title"));
        setDescription(rs.getString("description"));
        setAvailable(rs.getBoolean("available"));
        setPicture1Url(rs.getString("picture_1_url"));
        setPicture2Url(rs.getString("picture_2_url"));
        setPicture3Url(rs.getString("picture_3_url"));
        setPicture4Url(rs.getString("picture_4_url"));
        setPicture5Url(rs.getString("picture_5_url"));
        setPicture6Url(rs.getString("picture_6_url"));
        setPicture7Url(rs.getString("picture_7_url"));
        setPicture8Url(rs.getString("picture_8_url"));
        setPicture9Url(rs.getString("picture_9_url"));
        setPicture10Url(rs.getString("picture_10_url"));
        setOwnerId(rs.getString("owner_id"));
        setCategoryId(rs.getString("category_id"));
    }

    public void populatePs(PreparedStatement ps) throws Exception {
        ps.setString(1, getTitle());
        ps.setString(2, getDescription());
        ps.setBoolean(3, getAvailable());
        ps.setString(4, getPicture1Url());
        ps.setString(5, getPicture2Url());
        ps.setString(6, getPicture3Url());
        ps.setString(7, getPicture4Url());
        ps.setString(8, getPicture5Url());
        ps.setString(9, getPicture6Url());
        ps.setString(10, getPicture7Url());
        ps.setString(11, getPicture8Url());
        ps.setString(12, getPicture9Url());
        ps.setString(13, getPicture10Url());
        ps.setString(14, getOwnerId());
        ps.setString(15, getId());
        ps.setString(16, getCreatedAt());
        ps.setString(17, getUpdatedAt());
        ps.setString(18, getDeletedAt());
        ps.setString(19, getCategoryId());
    }

    @Override
    public String validate() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getPicture1Url() {
        return picture1Url;
    }

    public void setPicture1Url(String picture1Url) {
        this.picture1Url = picture1Url;
    }

    public String getPicture2Url() {
        return picture2Url;
    }

    public void setPicture2Url(String picture2Url) {
        this.picture2Url = picture2Url;
    }

    public String getPicture3Url() {
        return picture3Url;
    }

    public void setPicture3Url(String picture3Url) {
        this.picture3Url = picture3Url;
    }

    public String getPicture4Url() {
        return picture4Url;
    }

    public void setPicture4Url(String picture4Url) {
        this.picture4Url = picture4Url;
    }

    public String getPicture5Url() {
        return picture5Url;
    }

    public void setPicture5Url(String picture5Url) {
        this.picture5Url = picture5Url;
    }

    public String getPicture6Url() {
        return picture6Url;
    }

    public void setPicture6Url(String picture6Url) {
        this.picture6Url = picture6Url;
    }

    public String getPicture7Url() {
        return picture7Url;
    }

    public void setPicture7Url(String picture7Url) {
        this.picture7Url = picture7Url;
    }

    public String getPicture8Url() {
        return picture8Url;
    }

    public void setPicture8Url(String picture8Url) {
        this.picture8Url = picture8Url;
    }

    public String getPicture9Url() {
        return picture9Url;
    }

    public void setPicture9Url(String picture9Url) {
        this.picture9Url = picture9Url;
    }

    public String getPicture10Url() {
        return picture10Url;
    }

    public void setPicture10Url(String picture10Url) {
        this.picture10Url = picture10Url;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
