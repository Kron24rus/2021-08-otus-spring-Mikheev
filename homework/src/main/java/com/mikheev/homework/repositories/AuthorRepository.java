package com.mikheev.homework.repositories;


import com.mikheev.homework.domain.Author;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
}
