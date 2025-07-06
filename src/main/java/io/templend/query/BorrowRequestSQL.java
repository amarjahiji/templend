package io.templend.query;

public class BorrowRequestSQL {

    public static final String SAVE = "insert into borrowing_requests (id, borrower_id, lender_id, item_id, status, created_at)\n" +
            "values (?, ?, ?, ?, ?, now())\n" +
            "on duplicate key update status     = values(status),\n" +
            "                        updated_at = now();";
}
