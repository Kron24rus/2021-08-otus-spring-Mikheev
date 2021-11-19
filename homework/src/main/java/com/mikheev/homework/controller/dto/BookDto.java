package com.mikheev.homework.controller.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String id;
    private String title;
    private AuthorDto author;
    private GenreDto genre;
    private List<CommentDto> comments;
}
