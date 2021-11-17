package com.mikheev.homework.repositories.impl;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.BookCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

    private final ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<Book> findByIdWithComments(String id) {
        return mongoTemplate.findById(id, Book.class);
    }

    @Override
    public void deleteByIdCascadeComments(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("book.$id").is(id));
        mongoTemplate.findAllAndRemove(query, Comment.class).subscribe();
        Query bookQuery = new Query();
        bookQuery.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(bookQuery, Book.class).subscribe();
    }
}
