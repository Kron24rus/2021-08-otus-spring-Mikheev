package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Author;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.service.AuthorService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @CircuitBreaker(name = "authorService")
    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
