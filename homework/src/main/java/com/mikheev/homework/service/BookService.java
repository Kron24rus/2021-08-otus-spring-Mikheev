package com.mikheev.homework.service;

import com.mikheev.homework.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookWithAllAssociations(long id);

    void addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(long id);
}
