package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Author;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.utils.EntityFormatterUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public String getAllAuthorsAsString() {
        List<Author> authors = authorRepository.findAll();
        return EntityFormatterUtils.prettyPrintEntity(authors, "Authors in database");
    }

    @Transactional(readOnly = true)
    @Override
    public String getAuthorAsString(String id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor
                .map(author -> EntityFormatterUtils.prettyPrintEntity(Collections.singletonList(author), "Author with id: " + id))
                .orElseGet(() -> "No Author with id: " + id + "\n");
    }
}
