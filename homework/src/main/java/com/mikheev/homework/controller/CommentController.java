package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.CommentDto;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @PostMapping("/comment")
    public CommentDto addComment(@RequestBody CommentDto commentDto) {
        return modelMapper.map(commentService
                .addComment(commentDto.getBookId(), modelMapper.map(commentDto, Comment.class)), CommentDto.class);
    }

    @PutMapping("/comment")
    public CommentDto updateBook(@RequestBody Comment comment) {
        return modelMapper.map(commentService.updateComment(comment), CommentDto.class);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable("id") long id) {
        commentService.deleteComment(id);
    }
}
