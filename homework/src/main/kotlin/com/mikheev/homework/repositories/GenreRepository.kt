package com.mikheev.homework.repositories

import com.mikheev.homework.domain.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository : JpaRepository<Genre, Long>
