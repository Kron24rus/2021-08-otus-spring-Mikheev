package com.mikheev.homework.repositories;


import com.mikheev.homework.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
