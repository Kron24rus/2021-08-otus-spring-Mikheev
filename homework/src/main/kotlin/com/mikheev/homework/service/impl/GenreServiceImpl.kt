package com.mikheev.homework.service.impl

import com.mikheev.homework.domain.Genre
import com.mikheev.homework.repositories.GenreRepository
import com.mikheev.homework.service.GenreService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GenreServiceImpl(private val genreRepository: GenreRepository) : GenreService {

    @Transactional(readOnly = true)
    override fun getAllGenres(): List<Genre> {
        return genreRepository.findAll()
    }
}