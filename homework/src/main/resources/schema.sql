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
