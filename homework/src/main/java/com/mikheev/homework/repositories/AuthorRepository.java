package com.mikheev.homework.repositories;


import com.mikheev.homework.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
