DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS (
    ID BIGINT IDENTITY PRIMARY KEY,
    NAME VARCHAR(255));

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES (
    ID BIGINT IDENTITY PRIMARY KEY,
    NAME VARCHAR(255));

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
    ID BIGINT IDENTITY PRIMARY KEY,
    TITLE VARCHAR(255),
    AUTHOR_ID BIGINT REFERENCES AUTHORS(ID) ON DELETE CASCADE,
     GENRE_ID BIGINT REFERENCES GENRES(ID));

DROP TABLE IF EXISTS COMMENTS;
CREATE TABLE COMMENTS (
    ID BIGINT IDENTITY PRIMARY KEY,
    TEXT VARCHAR(1024),
    BOOK_ID BIGINT REFERENCES BOOKS(ID) ON DELETE CASCADE);

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    ID BIGINT IDENTITY PRIMARY KEY,
    USERNAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    ENABLED boolean NOT NULL);

DROP TABLE IF EXISTS REFRESHTOKENS;
CREATE TABLE REFRESHTOKENS (
    ID BIGINT IDENTITY PRIMARY KEY,
    TOKEN VARCHAR(255) NOT NULL,
    EXPIRATION_DATE TIMESTAMP,
    USER_ID BIGINT REFERENCES USERS(ID) ON DELETE CASCADE);