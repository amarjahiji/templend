package io.templend.model;

import com.google.gson.annotations.SerializedName;

public class BorrowRequestDetail extends AbstractModel {
    @SerializedName("item")
    private Item item;
    @SerializedName("borrower")
    private User borrower;
    @SerializedName("request")
    private BorrowRequest request;


    @Override
    public String validate() {
        return null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public BorrowRequest getRequest() {
        return request;
    }

    public void setRequest(BorrowRequest request) {
        this.request = request;
    }
}

