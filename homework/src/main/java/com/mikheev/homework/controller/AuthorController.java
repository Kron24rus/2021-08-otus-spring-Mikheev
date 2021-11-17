package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("/author")
    public Flux<Author> authorList() {
        return authorRepository.findAll();
    }
}
