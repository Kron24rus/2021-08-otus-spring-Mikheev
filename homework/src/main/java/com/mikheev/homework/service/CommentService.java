package com.mikheev.homework.service;

public interface CommentService {

    String getAllBookCommentsAsString(String id);

    String addComment(String bookId, String text);

    String updateComment(String commentId, String text);

    String deleteComment(String commentId);

    String copyComment(String commentId, String bookId);
}
