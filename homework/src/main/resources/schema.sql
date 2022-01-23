DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS COMMENTS;
DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS GENRES;
DROP TABLE IF EXISTS REFRESHTOKENS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS USERS;

CREATE TABLE AUTHORS (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NAME VARCHAR(255));

CREATE TABLE GENRES (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NAME VARCHAR(255));

CREATE TABLE BOOKS (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    TITLE VARCHAR(255),
    AUTHOR_ID BIGINT REFERENCES AUTHORS(ID) ON DELETE CASCADE,
     GENRE_ID BIGINT REFERENCES GENRES(ID));

CREATE TABLE COMMENTS (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    TEXT VARCHAR(1024),
    BOOK_ID BIGINT REFERENCES BOOKS(ID) ON DELETE CASCADE);

CREATE TABLE USERS (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    USERNAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    ENABLED boolean NOT NULL);

CREATE TABLE ROLES (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NAME varchar(255));

CREATE TABLE USER_ROLES (
    USER_ID BIGINT NOT NULL,
    ROLE_ID bigint NOT NULL,
    PRIMARY KEY (USER_ID, ROLE_ID));

ALTER TABLE USER_ROLES ADD CONSTRAINT FKUser FOREIGN KEY (USER_ID) references USERS;
ALTER TABLE USER_ROLES ADD CONSTRAINT FKRole FOREIGN KEY (ROLE_ID) references ROLES;

CREATE TABLE REFRESHTOKENS (
    ID bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    TOKEN VARCHAR(255) NOT NULL,
    EXPIRATION_DATE TIMESTAMP,
    USER_ID BIGINT REFERENCES USERS(ID) ON DELETE CASCADE);