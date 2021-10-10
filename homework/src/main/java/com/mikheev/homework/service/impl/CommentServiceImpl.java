package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import com.mikheev.homework.service.CommentService;
import com.mikheev.homework.utils.EntityFormatterUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    public CommentServiceImpl(CommentRepository commentRepository, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public String getAllBookCommentsAsString(String id) {
        List<Comment> comments = commentRepository.findByBookId(id);
        StringBuilder resultMessage = new StringBuilder();
        if (comments != null && !comments.isEmpty()) {
            resultMessage.append(EntityFormatterUtils.prettyPrintEntity(comments, "Comments for book"));
        } else {
            resultMessage.append("Comments for Book with id: ").append(id).append(" not found.");
        }
        return resultMessage.toString();
    }

    @Override
    public String addComment(String bookId, String text) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            Comment comment = new Comment();
            comment.setText(text);
            comment.setBook(book);
            Comment savedComment = commentRepository.save(comment);
            return "Added new comment with id: " + savedComment.getId();
        } else {
            return "Book with id: " + bookId + " not found.";
        }
    }

    @Override
    public String updateComment(String commentId, String text) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setText(text);
            commentRepository.save(comment);
            return "Comment updated";
        } else {
            return "Comment with id " + commentId + " not found";
        }
    }

    @Override
    public String deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
        return "Comment with id: " + commentId + " removed from database";
    }

    @Override
    public String copyComment(String commentId, String bookId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent() && optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            Book book = optionalBook.get();
            Comment newComment = new Comment();
            newComment.setText(comment.getText());
            newComment.setBook(book);
            commentRepository.save(newComment);
            return "Comment with id: " + commentId + " copied to book with id: " + bookId;
        } else {
            return "Comment and/or book with specified id not found";
        }
    }
}
