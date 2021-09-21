package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.GenreService;
import com.mikheev.homework.utils.EntityFormatterUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public String getAllGenresAsString() {
        List<Genre> genres = genreRepository.findAll();
        return EntityFormatterUtils.prettyPrintEntity(genres, "Genres in database");
    }

    @Transactional(readOnly = true)
    @Override
    public String getGenreAsString(long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        return optionalGenre
                .map(genre -> EntityFormatterUtils.prettyPrintEntity(Collections.singletonList(genre), "Genre with id: " + id))
                .orElseGet(() -> "No Genre with id: " + id + "\n");
    }
}
