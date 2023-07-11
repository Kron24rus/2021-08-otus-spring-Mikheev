package com.mikheev.homework.service

import com.mikheev.homework.domain.Genre

interface GenreService {

    fun getAllGenres(): List<Genre>
}