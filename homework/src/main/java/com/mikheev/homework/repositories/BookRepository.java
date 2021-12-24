package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "book")
public interface BookRepository extends JpaRepository<Book, Long>, BookCustomRepository {
}
