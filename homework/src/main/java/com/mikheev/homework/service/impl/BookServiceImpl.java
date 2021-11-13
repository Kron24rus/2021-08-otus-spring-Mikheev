package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.exception.NotFoundException;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @Transactional(readOnly = true)
    @Override
    public Book getBookWithAllAssociations(String id) {
        return bookRepository.findByIdWithComments(id)
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found!"));
    }

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


    @Transactional
    @Override
    public void deleteBook(String id) {
        bookRepository.deleteByIdCascadeComments(id);
    }
}
