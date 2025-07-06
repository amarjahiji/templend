package io.templend.model;

import com.google.gson.annotations.SerializedName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRequest extends AbstractModel {
    @SerializedName("item_id")
    private String itemId;
    @SerializedName("lender_id")
    private String lenderId;
    @SerializedName("borrower_id")
    private String borrowerId;
    @SerializedName("status")
    private STATUS status;

    @Override
    public String validate() {
        return null;
    }

    public BorrowRequest(ResultSet rs) throws SQLException {
        setItemId(rs.getString("item_id"));
        setLenderId(rs.getString("lender_id"));
        setBorrowerId(rs.getString("borrower_id"));
        setStatus(STATUS.valueOf(rs.getString("status")));
        setCreatedAt(rs.getString("created_at"));
        setUpdatedAt(rs.getString("updated_at"));
    }

    public void populatePs(PreparedStatement ps) throws Exception {
        ps.setString(1, getId());
        ps.setString(2, getItemId());
        ps.setString(3, getLenderId());
        ps.setString(4, getBorrowerId());
        ps.setString(5, getStatus().name());
        ps.setString(6, getCreatedAt());
        ps.setString(7, getUpdatedAt());
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public enum STATUS {
        PENDING,
        CANCELED,
        ACCEPTED,
        REJECTED;
    }
}
