package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Genre;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {
}
