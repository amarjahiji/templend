package io.templend.query;

public class ItemSQL {
    public static final String GET = "select * from items;";

    public static final String GET_BY_ID = "select * from items where id = ?;";

    public static final String GET_BY_OWNER_ID = "select * from items where owner_id = ?;";

    public static final String SAVE = "insert into items (id, title, description, available, created_at, updated_at, deleted_at,\n" +
            "                   picture_1_url, picture_2_url, picture_3_url, picture_4_url, picture_5_url,\n" +
            "                   picture_6_url, picture_7_url, picture_8_url, picture_9_url, picture_10_url,\n" +
            "                   owner_id, category_id)\n" +
            "values (?, ?, ?, ?, ?, ?, ?,\n" +
            "        ?, ?, ?, ?, ?,\n" +
            "        ?, ?, ?, ?, ?,\n" +
            "        ?, ?)\n" +
            "on duplicate key update title          = values(title),\n" +
            "                        description    = values(description),\n" +
            "                        available      = values(available),\n" +
            "                        updated_at     = values(updated_at),\n" +
            "                        deleted_at     = values(deleted_at),\n" +
            "                        picture_1_url  = values(picture_1_url),\n" +
            "                        picture_2_url  = values(picture_2_url),\n" +
            "                        picture_3_url  = values(picture_3_url),\n" +
            "                        picture_4_url  = values(picture_4_url),\n" +
            "                        picture_5_url  = values(picture_5_url),\n" +
            "                        picture_6_url  = values(picture_6_url),\n" +
            "                        picture_7_url  = values(picture_7_url),\n" +
            "                        picture_8_url  = values(picture_8_url),\n" +
            "                        picture_9_url  = values(picture_9_url),\n" +
            "                        picture_10_url = values(picture_10_url),\n" +
            "                        category_id    = values(category_id);";

    public static final String DELETE_BY_ID = "delete from items where id = ?";

    public static final String COUNT = "select count(*) from items";

    public static final String PAGINATION = "select *\n" +
            "from items\n" +
            "order by created_at\n" +
            "    desc\n" +
            "limit ? offset ?";

    public static final String GET_BY_KEYWORD = "select *\n" +
            "from items\n" +
            "where title like ?;";

    public static final String GET_BY_AVAILABILITY = "select *\n" +
            "from items\n" +
            "where available = ?;";

    public static final String GET_BY_CATEGORY_IDS = "select *\n" +
            "from items\n" +
            "where category_id in ?";

    public static final String GET_BY_CATEGORY_ID = "select * from items where category_id = ?;";
}
