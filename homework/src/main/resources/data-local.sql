insert into genres (id, name) values (0, 'detective');
insert into genres (id, name) values (1, 'comedy');
insert into genres (id, name) values (2, 'criminal');
insert into genres (id, name) values (3, 'fantasy');

insert into authors (id, name) values (0, 'AuthorOfDetectiveAndComedy');
insert into authors (id, name) values (1, 'TalentedAuthor');
insert into authors (id, name) values (2, 'BadAndBoringAuthor');

insert into books (id, title, author_id, genre_id) values (0, 'comedyBook', 0, 1);
insert into books (id, title, author_id, genre_id) values (1, 'detectiveBook', 0, 0);
insert into books (id, title, author_id, genre_id) values (2, 'criminalBook', 1, 2);
insert into books (id, title, author_id, genre_id) values (3, 'fantasyBook', 1, 3);
insert into books (id, title, author_id, genre_id) values (4, 'criminalBookOfBadAuthor', 2, 2);
insert into books (id, title, author_id, genre_id) values (5, 'criminalBookOfTalented', 1, 2);
insert into books (id, title, author_id, genre_id) values (6, 'detectiveOfBadAuthor', 2, 0);
insert into books (id, title, author_id, genre_id) values (7, 'comedyOfBoringAuthor', 2, 1);

insert into comments (id, text, book_id) values (1, 'positive comment', 0);
insert into comments (id, text, book_id) values (2, 'negative comment', 1);
insert into comments (id, text, book_id) values (3, 'neutral comment', 2);
insert into comments (id, text, book_id) values (4, 'positive comment2', 0);
insert into comments (id, text, book_id) values (5, 'negative comment2', 1);
insert into comments (id, text, book_id) values (6, 'neutral comment2', 2);
insert into comments (id, text, book_id) values (7, 'positive comment3', 0);
insert into comments (id, text, book_id) values (8, 'negative comment3', 1);
insert into comments (id, text, book_id) values (9, 'neutral comment3', 2);
insert into comments (id, text, book_id) values (10, 'positive comment4', 0);
insert into comments (id, text, book_id) values (11, 'negative comment4', 1);
insert into comments (id, text, book_id) values (12, 'neutral comment4', 2);
insert into comments (id, text, book_id) values (13, 'positive comment5', 0);
insert into comments (id, text, book_id) values (14, 'negative comment5', 1);
insert into comments (id, text, book_id) values (15, 'neutral comment5', 2);
insert into comments (id, text, book_id) values (16, 'positive comment6', 0);
insert into comments (id, text, book_id) values (17, 'negative comment6', 1);
insert into comments (id, text, book_id) values (18, 'neutral comment6', 2);
insert into comments (id, text, book_id) values (19, 'positive comment7', 0);
insert into comments (id, text, book_id) values (20, 'negative comment7', 1);
insert into comments (id, text, book_id) values (21, 'neutral comment7', 2);
insert into comments (id, text, book_id) values (22, 'positive comment8', 0);
insert into comments (id, text, book_id) values (23, 'negative comment8', 1);
insert into comments (id, text, book_id) values (24, 'neutral comment8', 2);
insert into comments (id, text, book_id) values (25, 'positive comment', 3);
insert into comments (id, text, book_id) values (26, 'negative comment', 4);
insert into comments (id, text, book_id) values (27, 'neutral comment', 5);
insert into comments (id, text, book_id) values (28, 'positive comment', 6);
insert into comments (id, text, book_id) values (29, 'negative comment', 7);

insert into users (id, username, password, enabled) values (1, 'admin', '$2a$12$KqgkGVzJ3Fbn9tZZGfeoRuRyg6od983W1TYDYUkdmznK356Sf.ONu', true);
insert into users (id, username, password, enabled) values (2, 'user', '$2a$12$y48Osj.DWsdf21obKpiYHOFuX9DaV0VpXbJanu8.JeNZ9vt54V3hO', true);
insert into users (id, username, password, enabled) values (3, 'moderator', '$2a$12$lHsk7GDy5mMbqz0FpWVsCOZCMCS7lZpsbGi/tJ5XvKe0ZOFoqdvRi', true);

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_MODERATOR');

INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (2, 2);
INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (3, 3);
