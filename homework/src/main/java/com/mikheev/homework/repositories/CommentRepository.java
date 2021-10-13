package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByBookId(String bookId);
}
