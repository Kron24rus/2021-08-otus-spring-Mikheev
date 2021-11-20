package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookRepository extends ReactiveMongoRepository<Book, String>, BookCustomRepository {
}
