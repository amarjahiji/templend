package io.templend.query;

public class BorrowRequestDetailSQL {

    public static final String GET_PENDING_BY_LENDER = "select i.title,\n" +
            "       i.description,\n" +
            "       i.picture_1_url,\n" +
            "       u.username,\n" +
            "       br.status,\n" +
            "       br.created_at,\n" +
            "       br.updated_at\n" +
            "from items i\n" +
            "         join borrowing_requests br on i.id = br.item_id\n" +
            "         join users u on u.id = br.borrower_id\n" +
            "where br.status = 'PENDING'\n" +
            "  and br.lender_id = ?\n" +
            "order by br.created_at desc;";

    public static final String GET_PENDING_BY_LENDERS_ITEM = "select i.title,\n" +
            "       i.description,\n" +
            "       i.picture_1_url,\n" +
            "       u.username,\n" +
            "       br.status,\n" +
            "       br.created_at,\n" +
            "       br.updated_at\n" +
            "from items i\n" +
            "         join borrowing_requests br on i.id = br.item_id\n" +
            "         join users u on u.id = br.borrower_id\n" +
            "where br.status = 'PENDING'\n" +
            "  and br.lender_id = ?\n" +
            "  and br.item_id = ?\n" +
            "order by br.created_at desc;";

    public static final String GET_BY_BORROWER = "select i.title,\n" +
            "       i.description,\n" +
            "       i.picture_1_url,\n" +
            "       u.username,\n" +
            "       br.status,\n" +
            "       br.created_at,\n" +
            "       br.updated_at\n" +
            "from items i\n" +
            "         join borrowing_requests br on i.id = br.item_id\n" +
            "         join users u on u.id = br.lender_id\n" +
            "where br.borrower_id = ?\n" +
            "order by br.created_at desc;";
}
