create database onu2;

create table account
(
    id                 bigint auto_increment                 primary key,
    username           varchar(100)                          not null,
    password           char(200)                             null,
    auth_provider      varchar(20) default 'NONE'            not null,
    account_expired    tinyint(1)  default 0                 not null,
    account_locked     tinyint(1)  default 0                 not null,
    account_locked_at  timestamp                             null,
    credential_expired tinyint(1)  default 0                 not null,
    enabled            tinyint(1)  default 1                 not null,
    name               varchar(50)                           null,
    description        varchar(100)                          null,
    tel_enc            varchar(30)                           null,
    picture_url        varchar(300)                          null,
    email              varchar(30)                           null,
    authority          char(10)    default 'ROLE_USER'       null,
    created_at         timestamp   default CURRENT_TIMESTAMP not null,
    created_by         varchar(10) default 'SYSTEM'          not null,
    modified_at        timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    modified_by        varchar(10) default 'SYSTEM'          not null,
    constraint user_pk
        unique (username, auth_provider)
);

create table store
(
    id              bigint auto_increment                 primary key,
    account_id      bigint                                not null,
    deleted         tinyint(1)  default 0                 not null,
    name            varchar(100)                          not null,
    operating_hours varchar(100)                          null,
    description     varchar(500)                          null,
    img_url         varchar(2083)                         null,
    phone_number    varchar(20)                           null,
    facebook_url    varchar(2083)                         null,
    instagram_url   varchar(2083)                         null,
    email           varchar(50)                           null,
    created_at      timestamp   default CURRENT_TIMESTAMP not null,
    created_by      varchar(10) default 'SYSTEM'          not null,
    modified_at     timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    modified_by     varchar(10) default 'SYSTEM'          not null,
    story_id        bigint                                null,
    constraint store_account_id_fk
        foreign key (account_id) references account (id)
);

create table menu
(
    id          bigint auto_increment                    primary key,
    store_id    bigint                                   not null,
    account_id  bigint                                   not null,
    name        varchar(50)                              not null,
    price       decimal(10, 2) default 0.00              not null,
    category_id bigint                                   not null comment 'set to -1 when category is deleted ',
    description varchar(1000)                            null,
    img_url     varchar(2083)                            null,
    created_at  timestamp      default CURRENT_TIMESTAMP not null,
    created_by  varchar(10)    default 'SYSTEM'          not null,
    modified_at timestamp      default CURRENT_TIMESTAMP not null,
    modified_by varchar(10)    default 'SYSTEM'          not null,
    constraint menu_store_id_fk
        foreign key (store_id) references store (id)
);

create table attribute
(
    id          bigint auto_increment                 primary key,
    menu_id     bigint                                not null,
    account_id  bigint                                not null,
    name        varchar(100)                          not null,
    rating      int                                   not null,
    created_at  timestamp   default CURRENT_TIMESTAMP not null,
    created_by  varchar(10) default 'SYSTEM'          not null,
    modified_at timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    modified_by varchar(10) default 'SYSTEM'          not null,
    constraint attribute_menu_id_fk
        foreign key (menu_id) references menu (id)
);

create table category
(
    id          bigint auto_increment                 primary key,
    store_id    bigint                                not null,
    name        varchar(100)                          not null,
    menu_ids    varchar(100)                          null,
    account_id  bigint                                not null,
    created_at  timestamp   default CURRENT_TIMESTAMP not null,
    created_by  varchar(10) default 'SYSTEM'          not null,
    modified_at timestamp   default CURRENT_TIMESTAMP not null,
    modified_by varchar(10) default 'SYSTEM'          not null,
    constraint category_store_id_fk
        foreign key (store_id) references store (id)
);

create index menu_category_id_index on menu (category_id);

create table qr
(
    id          bigint auto_increment                 primary key,
    store_id    bigint                                not null,
    account_id  bigint                                not null,
    title       varchar(100)                          not null,
    description varchar(1000)                         null,
    created_at  timestamp   default CURRENT_TIMESTAMP not null,
    created_by  varchar(10) default 'SYSTEM'          not null,
    modified_at timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    modified_by varchar(10) default 'SYSTEM'          not null,
    constraint qr_store_id_fk
        foreign key (store_id) references store (id)
);

create table recommendation
(
    id          bigint auto_increment                 primary key,
    store_id    bigint                                not null,
    account_id  bigint                                not null,
    title       varchar(100)                          not null,
    description varchar(1000)                         null,
    menu_ids    varchar(100)                          null,
    created_at  timestamp   default CURRENT_TIMESTAMP not null,
    created_by  varchar(10) default 'SYSTEM'          not null,
    modified_at timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    modified_by varchar(10) default 'SYSTEM'          null,
    constraint recommendation_store_id_fk
        foreign key (store_id) references store (id)
);

create table story
(
    id          bigint auto_increment                 primary key,
    store_id    bigint                                not null,
    account_id  bigint                                not null,
    title       varchar(100)                          not null,
    subtitle    varchar(100)                          null,
    description varchar(1002)                         null,
    img_url     varchar(2083)                         null,
    active      tinyint(1)  default 1                 not null,
    created_at  timestamp   default CURRENT_TIMESTAMP not null,
    created_by  varchar(10) default 'SYSTEM'          not null,
    modified_at timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    modified_by varchar(10) default 'SYSTEM'          not null,
    constraint story_store_id_fk
        foreign key (store_id) references store (id)
);

