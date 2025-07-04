package io.templend.query;

public class CategorySQL {

    public static final String GET = "select * from categories";

    public static final String GET_BY_ID = "select * from categories where id = ?";

    public static final String SAVE = "insert into categories (id, name, description, created_at, updated_at, deleted_at)\n" +
            "values (?, ?, ?, ?, ?, ?)\n" +
            "on duplicate key update name        = values(name),\n" +
            "                        description = values(description),\n" +
            "                        updated_at  = values(updated_at),\n" +
            "                        deleted_at  = values(deleted_at);";

    public static final String GET_BY_NAME = "select * from categories where name = ?";

    public static final String GET_BY_IDS = "select * from categories where id in ?";
}
