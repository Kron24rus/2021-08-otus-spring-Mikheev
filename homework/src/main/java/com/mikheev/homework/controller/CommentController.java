package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/book/{id}/comment")
    public Comment addComment(@PathVariable("id") String bookId, @RequestBody Comment comment) {
        return commentService.addComment(bookId, comment);
    }

    @PutMapping("/comment")
    public Comment updateBook(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable("id") String id) {
        commentService.deleteComment(id);
    }
}
