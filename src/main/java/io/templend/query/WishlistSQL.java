package io.templend.query;

public class WishlistSQL {

    public static final String GET_BY_USER = "select i.title, i.description, i.picture_1_url\n" +
            "from items i\n" +
            "         inner join wishlists w on i.id = w.item_id\n" +
            "where w.user_id = ?;";

    public static final String CREATE = "insert into wishlists (user_id, item_id, created_at)\n" +
            "values (?, ?, now());";
}
