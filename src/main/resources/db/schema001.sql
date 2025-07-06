create table users
(
    id                  char(36) primary key,
    username            varchar(255)                         not null,
    first_name          varchar(255)                         not null,
    last_name           varchar(255)                         not null,
    email               varchar(255)                         not null,
    password            varchar(255)                         not null,
    phone               varchar(255),
    address             varchar(255),
    role                enum ('BORROWER', 'LENDER', 'ADMIN') not null default 'BORROWER',
    active              tinyint(1)                           not null default 0,
    profile_picture_url varchar(255),
    email_verified      tinyint(1)                           not null default 0,
    phone_verified      tinyint(1)                           not null default 0,
    birthday            date                                 not null,
    created_at          timestamp                            not null,
    updated_at          timestamp,
    deleted_at          datetime,
    constraint u_username unique (username),
    constraint u_email unique (email),
    constraint u_phone unique (phone)
);

create table items
(
    id             char(36) primary key,
    title          varchar(255) not null,
    description    text         not null,
    available      tinyint(1)   not null default 1,
    created_at     timestamp    not null,
    updated_at     timestamp,
    deleted_at     timestamp,
    picture_1_url  varchar(255) not null,
    picture_2_url  varchar(255) not null,
    picture_3_url  varchar(255) not null,
    picture_4_url  varchar(255) not null,
    picture_5_url  varchar(255) not null,
    picture_6_url  varchar(255),
    picture_7_url  varchar(255),
    picture_8_url  varchar(255),
    picture_9_url  varchar(255),
    picture_10_url varchar(255),
    owner_id       char(36),
    category_id    char(36),
    constraint owner_fk foreign key (owner_id) references users (id),
    constraint category_fk foreign key (category_id) references categories (id)
);

create table categories
(
    id          char(36) primary key,
    name        varchar(255) not null,
    description text,
    created_at  timestamp    not null,
    updated_at  timestamp,
    deleted_at  timestamp
);

create table comments
(
    id                char(36) primary key,
    text              text      not null,
    item_id           char(36),
    user_id           char(36),
    parent_comment_id char(36),
    created_at        timestamp not null,
    updated_at        timestamp,
    deleted_at        timestamp,
    constraint item_fk foreign key (item_id) references items (id),
    constraint user_fk foreign key (user_id) references users (id),
    constraint comment_fk foreign key (parent_comment_id) references comments (id)
);

create table reviews
(
    id            char(36) primary key,
    item_rating   int       not null,
    owner_rating  int       not null,
    item_comment  text,
    owner_comment text,
    owner_id      char(36),
    user_id       char(36),
    item_id       char(36),
    created_at    timestamp not null,
    updated_at    timestamp,
    deleted_at    timestamp,
    constraint review_user_fk foreign key (user_id) references users (id),
    constraint review_owner_fk foreign key (owner_id) references users (id),
    constraint review_item_fk foreign key (item_id) references items (id),
    constraint i_rating_range check (item_rating between 1 and 10),
    constraint u_rating_range check (owner_rating between 1 and 10)
);

create table wishlists
(
    user_id    char(36),
    item_id    char(36),
    created_at timestamp not null,
    deleted_at timestamp,
    primary key (user_id, item_id)
);

create table borrowing_requests
(
    id          char(36) primary key,
    borrower_id char(36),
    lender_id   char(36),
    item_id     char(36),
    status      enum ('PENDING', 'APPROVED', 'REJECTED', 'CANCELLED'),
    created_at  timestamp not null,
    updated_at  timestamp,
    constraint br_lender_id_fk foreign key (lender_id) references users (id),
    constraint br_borrower_id_fk foreign key (borrower_id) references users (id),
    constraint br_item_id_fk foreign key (item_id) references items (id)
);


