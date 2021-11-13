package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;

import java.util.Optional;

public interface BookCustomRepository {

    Optional<Book> findByIdWithComments(String id);

    void deleteByIdCascadeComments(String id);
}
