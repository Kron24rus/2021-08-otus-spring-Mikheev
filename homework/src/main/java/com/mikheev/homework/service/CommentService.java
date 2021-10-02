package com.mikheev.homework.service;

public interface CommentService {

    String getAllBookCommentsAsString(long id);

    String addComment(long bookId, String text);

    String updateComment(long commentId, String text);

    String deleteComment(long commentId);

    String copyComment(long commentId, long bookId);
}
