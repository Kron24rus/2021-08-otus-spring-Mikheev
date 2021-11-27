package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author")
    public List<Author> authorList() {
        return authorService.getAllAuthors();
    }
}
