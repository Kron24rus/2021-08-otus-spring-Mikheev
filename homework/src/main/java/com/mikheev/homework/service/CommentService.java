package com.mikheev.homework.service;

import com.mikheev.homework.domain.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {

    Comment addComment(long bookId, Comment comment);

    Comment updateComment(Comment comment);

    void deleteComment(long commentId);
}
