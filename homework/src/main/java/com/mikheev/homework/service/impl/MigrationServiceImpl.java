package com.mikheev.homework.service.impl;

import com.mikheev.homework.mongo.domain.Author;
import com.mikheev.homework.mongo.domain.Book;
import com.mikheev.homework.mongo.domain.Comment;
import com.mikheev.homework.mongo.domain.Genre;
import com.mikheev.homework.service.MigrationService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MigrationServiceImpl implements MigrationService {

    private final MongoTemplate mongoTemplate;

    @Override
    public Author migrateAuthorEntity(com.mikheev.homework.domain.Author author) {
        Author mongoAuthor = new Author();
        mongoAuthor.setId(author.getId().toString());
        mongoAuthor.setName(author.getName());
        return mongoAuthor;
    }

    @Override
    public Genre migrateGenreEntity(com.mikheev.homework.domain.Genre genre) {
        Genre mongoGenre = new Genre();
        mongoGenre.setId(genre.getId().toString());
        mongoGenre.setName(genre.getName());
        return mongoGenre;
    }

    @Override
    public Book migrateBookEntity(com.mikheev.homework.domain.Book book) {
        Author mongoAuthor = mongoTemplate.findById(book.getAuthor().getId().toString(), Author.class);
        Genre mongoGenre = mongoTemplate.findById(book.getGenre().getId().toString(), Genre.class);

        Book mongoBook = new Book();
        mongoBook.setId(book.getId().toString());
        mongoBook.setTitle(book.getTitle());
        mongoBook.setAuthor(mongoAuthor);
        mongoBook.setGenre(mongoGenre);

        return mongoBook;
    }

    @Override
    public Comment migrateCommentEntity(com.mikheev.homework.domain.Comment comment) {
        Book mongoBook = mongoTemplate.findById(comment.getBook().getId().toString(), Book.class);

        Comment mongoComment = new Comment();
        mongoComment.setId(comment.getId().toString());
        mongoComment.setText(comment.getText());
        mongoComment.setBook(mongoBook);

        return mongoComment;
    }
}
