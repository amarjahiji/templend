package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class User extends AbstractModel {
    @SerializedName("username")
    private String username;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("role")
    private Role role;
    @SerializedName("active")
    private Boolean active;
    @SerializedName("profile_picture_url")
    private String profilePictureUrl;
    @SerializedName("email_verified")
    private Boolean emailVerified;
    @SerializedName("phone_verified")
    private Boolean phoneVerified;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("items")
    private List<Item> items;

    public User(ResultSet rs) throws SQLException {
        setUsername(rs.getString("username"));
        setId(rs.getString("id"));
        setFirstName(rs.getString("first_name"));
        setLastName(rs.getString("last_name"));
        setEmail(rs.getString("email"));
        setPassword(rs.getString("password"));
        setPhone(rs.getString("phone"));
        setAddress(rs.getString("address"));
        setRole(Role.valueOf(rs.getString("role")));
        setActive(rs.getBoolean("active"));
        setProfilePictureUrl(rs.getString("profile_picture_url"));
        setEmailVerified(rs.getBoolean("email_verified"));
        setPhoneVerified(rs.getBoolean("phone_verified"));
        setBirthday(rs.getString("birthday"));
    }

    public void populatePs(PreparedStatement ps) throws SQLException {
        ps.setString(1, getId());
        ps.setString(2, getUsername());
        ps.setString(3, getFirstName());
        ps.setString(4, getLastName());
        ps.setString(5, getEmail());
        ps.setString(6, getPassword());
        ps.setString(7, getPhone());
        ps.setString(8, getAddress());
        ps.setString(9, getRole().name());
        ps.setBoolean(10, getActive());
        ps.setString(11, getProfilePictureUrl());
        ps.setBoolean(12, getEmailVerified());
        ps.setBoolean(13, getPhoneVerified());
        ps.setString(14, getBirthday());
    }

    @Override
    public String validate() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Boolean getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(Boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public enum Role {
        BORROWER,
        LENDER,
        ADMIN
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
