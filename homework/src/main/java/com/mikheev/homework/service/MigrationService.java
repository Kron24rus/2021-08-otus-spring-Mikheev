package com.mikheev.homework.service;

import com.mikheev.homework.mongo.domain.Author;
import com.mikheev.homework.mongo.domain.Book;
import com.mikheev.homework.mongo.domain.Comment;
import com.mikheev.homework.mongo.domain.Genre;

public interface MigrationService {

    Author migrateAuthorEntity(com.mikheev.homework.domain.Author author);

    Genre migrateGenreEntity(com.mikheev.homework.domain.Genre genre);

    Book migrateBookEntity(com.mikheev.homework.domain.Book book);

    Comment migrateCommentEntity(com.mikheev.homework.domain.Comment comment);
}
