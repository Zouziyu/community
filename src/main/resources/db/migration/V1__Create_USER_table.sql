create table USER
(
    ID           INT auto_increment,
    NAME         VARCHAR(150),
    ACCOUNT_ID   VARCHAR(150),
    TOKEN        VARCHAR(150),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);

create unique index USER_ID_UINDEX
    on USER (ID);

