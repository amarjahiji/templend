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
    constraint owner_fk foreign key (owner_id) references users (id)
);