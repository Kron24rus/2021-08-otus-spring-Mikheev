package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>, BookRepositoryCustom {
}
