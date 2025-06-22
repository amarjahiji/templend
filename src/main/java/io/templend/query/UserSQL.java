package io.templend.query;

public class UserSQL {
    public static final String GET = "select * from users";

    public static final String GET_BY_ID = "select * from users where id = ?";

    public static final String SAVE = "INSERT INTO users (id,\n" +
            "                   username,\n" +
            "                   first_name,\n" +
            "                   last_name,\n" +
            "                   email,\n" +
            "                   password,\n" +
            "                   phone,\n" +
            "                   address,\n" +
            "                   role,\n" +
            "                   active,\n" +
            "                   profile_picture_url,\n" +
            "                   email_verified,\n" +
            "                   phone_verified,\n" +
            "                   birthday,\n" +
            "                   created_at,\n" +
            "                   updated_at,\n" +
            "                   deleted_at)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
            "ON DUPLICATE KEY UPDATE username            = VALUES(username),\n" +
            "                        first_name          = VALUES(first_name),\n" +
            "                        last_name           = VALUES(last_name),\n" +
            "                        email               = VALUES(email),\n" +
            "                        password            = VALUES(password),\n" +
            "                        phone               = VALUES(phone),\n" +
            "                        address             = VALUES(address),\n" +
            "                        role                = VALUES(role),\n" +
            "                        active              = VALUES(active),\n" +
            "                        profile_picture_url = VALUES(profile_picture_url),\n" +
            "                        email_verified      = VALUES(email_verified),\n" +
            "                        phone_verified      = VALUES(phone_verified),\n" +
            "                        birthday            = VALUES(birthday),\n" +
            "                        updated_at          = VALUES(updated_at),\n" +
            "                        deleted_at          = VALUES(deleted_at);";

    public static final String GET_ID_BY_USERNAME_EMAIL_PHONE = "select id\n" +
            "from users\n" +
            "where username = ?\n" +
            "   or email = ?\n" +
            "   or phone = ?;";

    public static final String DELETE_BY_ID = "delete from users where id = ?;";

    public static final String GET_BY_USERNAME_EMAIL_PHONE_AND_PASSWORD = "select id\n" +
            "from users\n" +
            "where (email = ? or username = ? or phone = ?)\n" +
            "  and password = ?\n" +
            "  and email_verified = 1\n" +
            "  and (phone is null or phone_verified = 1);";
}
