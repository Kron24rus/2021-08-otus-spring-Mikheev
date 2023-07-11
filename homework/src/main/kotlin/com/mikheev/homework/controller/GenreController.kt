package com.mikheev.homework.controller

import com.mikheev.homework.domain.Genre
import com.mikheev.homework.service.GenreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/library")
class GenreController (val genreService: GenreService) {

    @GetMapping("/genre")
    fun genreList(): List<Genre> {
        return genreService.getAllGenres()
    }
}
