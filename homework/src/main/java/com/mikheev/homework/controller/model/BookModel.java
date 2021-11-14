package com.mikheev.homework.controller.model;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookModel {

    Book book;
    List<Comment> comments;
}
