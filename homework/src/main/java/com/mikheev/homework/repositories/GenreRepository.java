package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
