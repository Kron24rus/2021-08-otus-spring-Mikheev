package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {
//
//    private final GenreRepository genreRepository;
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<Genre> getAllGenres() {
//        return genreRepository.findAll();
//    }
}
