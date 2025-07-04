package io.templend.query;

public class CommentSQL {

    public static final String GET_BY_ID = "select * from comments where id = ?";

    public static final String GET_BY_ITEM = "select * from comments where item_id = ?";

    public static final String GET_BY_ITEMS = "select * from comments where item_id in ?";

    public static final String GET_BY_PARENT_ID = "select * from comments where parent_comment_id = ?";

    public static final String SAVE = "insert into comments (id, text, item_id, user_id, parent_comment_id, created_at)\n" +
            "values (?, ?, ?, ?, ?, now())\n" +
            "on duplicate key update text       = values(text),\n" +
            "                        updated_at = now();";
}
