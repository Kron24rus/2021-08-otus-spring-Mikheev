package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class CommentController {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @PostMapping("/book/{id}/comment")
    public Mono<Comment> addComment(@PathVariable("id") String bookId, @RequestBody Comment comment) {
        return bookRepository.findById(bookId).flatMap(book -> {
            comment.setBook(book);
            return commentRepository.insert(comment);
        });
    }

    @PutMapping("/comment")
    public Mono<Comment> updateComment(@RequestBody Comment comment) {
        return commentRepository.findById(comment.getId()).flatMap(databaseComment -> {
            databaseComment.setText(comment.getText());
            return commentRepository.save(databaseComment);
        });
    }

    @DeleteMapping("/comment/{id}")
    public Mono<Void> deleteComment(@PathVariable("id") String id) {
        return commentRepository.deleteById(id);
    }
}
