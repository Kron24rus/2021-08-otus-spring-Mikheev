package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Optional<Comment> findById(long id);

    List<Comment> findCommentsByBookId(long bookId);

    Comment save(Comment comment);

    void deleteById(long id);
}
