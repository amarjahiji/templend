package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Category extends AbstractModel {
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("items")
    List<Item> items;

    @Override
    public String validate() {
        return null;
    }

    public Category(ResultSet rs) throws Exception {
        setName(rs.getString("name"));
        setDescription(rs.getString("description"));
    }

    public void populatePs(PreparedStatement ps) throws Exception {
        ps.setString(1, getId());
        ps.setString(2, getName());
        ps.setString(3, getDescription());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
