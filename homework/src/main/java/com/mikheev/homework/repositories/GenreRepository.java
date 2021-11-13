package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
