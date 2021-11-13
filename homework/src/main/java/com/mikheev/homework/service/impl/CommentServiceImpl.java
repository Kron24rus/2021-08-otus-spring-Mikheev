package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.exception.NotFoundException;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import com.mikheev.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public Comment addComment(String bookId, Comment comment) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book with id " + bookId + " not found!"));
        comment.setBook(book);
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public Comment updateComment(Comment comment) {
        Comment databaseComment = commentRepository.findById(comment.getId())
                .orElseThrow(() -> new NotFoundException("Comment with id " + comment.getId() + " not found!"));
        databaseComment.setText(comment.getText());
        return commentRepository.save(databaseComment);
    }

    @Transactional
    @Override
    public void deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
    }
}
