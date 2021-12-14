package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.CommentDto;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'MODERATOR')")
    @PostMapping("/comment")
    public Comment addComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto.getBookId(), modelMapper.map(commentDto, Comment.class));
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PutMapping("/comment")
    public Comment updateBook(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable("id") long id) {
        commentService.deleteComment(id);
    }
}
