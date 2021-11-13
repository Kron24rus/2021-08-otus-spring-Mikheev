package com.mikheev.homework.repositories.impl;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.BookCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Optional<Book> findByIdWithComments(String id) {
        Book book = mongoTemplate.findById(id, Book.class);
        return Optional.ofNullable(book);
    }

    @Override
    public void deleteByIdCascadeComments(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("book.$id").is(id));
        mongoTemplate.findAllAndRemove(query, Comment.class);
        Query bookQuery = new Query();
        bookQuery.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(bookQuery, Book.class);
    }
}
