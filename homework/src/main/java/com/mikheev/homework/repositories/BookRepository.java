package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
