package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBookId(long bookId);
}
