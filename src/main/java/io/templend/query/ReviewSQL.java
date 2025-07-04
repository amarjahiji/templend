package io.templend.query;

public class ReviewSQL {

    public static final String GET_BY_ID = "select * from reviews where id = ?";

    public static final String GET_BY_ITEMS = "select * from reviews where item_id in ?";

    public static final String GET_FOR_ITEM = "select item_rating, item_comment, user_id\n" +
            "from reviews\n" +
            "where item_id = ?;";

    public static final String GET_FOR_OWNER = "select owner_rating, owner_comment, user_id\n" +
            "from reviews\n" +
            "where owner_id = ?;";

    public static final String SAVE = "insert into reviews(id, item_rating, owner_rating, item_comment, user_id, item_id, owner_comment, owner_id, created_at)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, now())\n" +
            "on duplicate key update item_rating   = values(item_rating),\n" +
            "                        owner_rating  = values(owner_rating),\n" +
            "                        item_comment  = values(item_comment),\n" +
            "                        owner_comment = values(owner_comment),\n" +
            "                        updated_at    = now();";

}