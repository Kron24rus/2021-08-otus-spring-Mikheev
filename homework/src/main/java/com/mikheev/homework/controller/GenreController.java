package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genre")
    public List<Genre> genreList() {
        return genreService.getAllGenres();
    }
}
