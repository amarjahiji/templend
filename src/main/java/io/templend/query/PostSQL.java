package io.templend.query;

public class PostSQL {

    public static final String GET_ITEM_USER_CATEGORY = "select i.*, u.*, c.*\n" +
            "from items i\n" +
            "inner join users u on i.owner_id = u.id\n" +
            "inner join categories c on i.category_id = c.id;";

    public static final String GET_ITEM_USER_CATEGORY_BY_ITEM = "select i.*, u.*, c.*\n" +
            "from items i\n" +
            "         inner join users u on i.owner_id = u.id\n" +
            "         inner join categories c on i.category_id = c.id\n" +
            "where i.id = ?;";
}
