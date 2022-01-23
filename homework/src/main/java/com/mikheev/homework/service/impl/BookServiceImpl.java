package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.exception.NotFoundException;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.BookService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.RollbackException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @CircuitBreaker(name = "bookService")
    @Retry(name = "bookService", fallbackMethod = "getEmptyBooksList")
    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        if (new Random().nextInt() % 2 == 0) {
            System.out.println("rollback throw");
            throw new RollbackException();
        }
        return bookRepository.findAll();
    }

    @CircuitBreaker(name = "bookService")
    @Transactional(readOnly = true)
    @Override
    public Book getBookWithAllAssociations(long id) {
        return bookRepository.findById(id, "book-with-all-associations")
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found!"));
    }

    @CircuitBreaker(name = "bookService")
    @Transactional
    @Override
    public Book addBook(Book book) {
        Author databaseAuthor = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new NotFoundException("Author with id " + book.getAuthor().getId() + " not found!"));
        Genre databaseGenre = genreRepository.findById(book.getGenre().getId())
                .orElseThrow(() -> new NotFoundException("Genre with id " + book.getGenre().getId() + " not found!"));
        Book bookToSave = new Book(book.getTitle(), databaseAuthor, databaseGenre);
        return bookRepository.save(bookToSave);
    }

    @CircuitBreaker(name = "bookService")
    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book databaseBook = bookRepository.findById(book.getId()).orElseThrow(NotFoundException::new);
        Author databaseAuthor = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new NotFoundException("Author with id " + book.getAuthor().getId() + " not found!"));
        Genre databaseGenre = genreRepository.findById(book.getGenre().getId())
                .orElseThrow(() -> new NotFoundException("Genre with id " + book.getGenre().getId() + " not found!"));
        databaseBook.setTitle(book.getTitle());
        databaseBook.setAuthor(databaseAuthor);
        databaseBook.setGenre(databaseGenre);
        return bookRepository.save(databaseBook);
    }

    @CircuitBreaker(name = "bookService")
    @Transactional
    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getEmptyBooksList(Exception e) {
        return Collections.emptyList();
    }
}
