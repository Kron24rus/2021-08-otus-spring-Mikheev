package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.CommentDto;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class CommentController {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @PostMapping("/comment")
    public Mono<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        return bookRepository.findById(commentDto.getBookId()).flatMap(book -> {
            Comment comment = modelMapper.map(commentDto, Comment.class);
            comment.setBook(book);
            return commentRepository.insert(comment)
                    .map(insertedComment -> modelMapper.map(insertedComment, CommentDto.class));
        });
    }

    @PutMapping("/comment")
    public Mono<CommentDto> updateComment(@RequestBody CommentDto commentDto) {
        return commentRepository.findById(commentDto.getId()).flatMap(databaseComment -> {
            databaseComment.setText(commentDto.getText());
            return commentRepository.save(databaseComment).map(comment -> modelMapper.map(comment, CommentDto.class));
        });
    }

    @DeleteMapping("/comment/{id}")
    public Mono<Void> deleteComment(@PathVariable("id") String id) {
        return commentRepository.deleteById(id);
    }
}
