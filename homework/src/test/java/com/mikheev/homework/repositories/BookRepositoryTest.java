package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"com.mikheev.homework.repositories", "com.mikheev.homework.configuration", "com.mikheev.homework.handler"})
public class BookRepositoryTest {

    private static final String BOOK_ID = "1";
    private static final int EXPECTED_NUMBER_OF_BOOKS = 3;
    private static final String EXPECTED_BOOK_TITLE = "expectedBookTitle";
    private static final String EXPECTED_BOOK_ID = "3";
    private static final String BOOK_TITLE_DETECTIVE = "detectiveBook";
    private Genre libraryGenre;
    private Author libraryAuthor;


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @BeforeEach
    void setUp() {
        libraryGenre = new Genre("0", "detective");
        libraryAuthor = new Author("0", "AuthorOfDetectiveAndComedy");
    }

    @Test
    void findById_validBook() {
        bookRepository.findById(BOOK_ID)
                .as(StepVerifier::create)
                .assertNext(book -> {
                    assertEquals(BOOK_ID, book.getId());
                    assertEquals(BOOK_TITLE_DETECTIVE, book.getTitle());
                })
                .verifyComplete();
    }

    @Test
    void findById_shouldReturnEmptyMono() {
        bookRepository.findById(EXPECTED_BOOK_ID)
                .as(StepVerifier::create)
                .verifyComplete();
    }

    @Test
    void findAllBooks_expectAllBooksFromRepository() {
        bookRepository.findAll()
                .as(StepVerifier::create)
                .expectNextCount(EXPECTED_NUMBER_OF_BOOKS)
                .verifyComplete();
    }

    @DirtiesContext
    @Test
    void saveBook_newBookSaved() {
        Book newBook = new Book();
        newBook.setTitle(EXPECTED_BOOK_TITLE);
        newBook.setAuthor(libraryAuthor);
        newBook.setGenre(libraryGenre);
        bookRepository.save(newBook)
                .as(StepVerifier::create)
                .assertNext(book -> {
                    assertEquals(EXPECTED_BOOK_TITLE, book.getTitle());
                    assertNotNull(book.getId());
                    assertNotNull(book.getGenre());
                    assertNotNull(book.getAuthor());
                })
                .verifyComplete();
    }

    @DirtiesContext
    @Test
    void saveBook_bookUpdated() {
        reactiveMongoTemplate.findById(BOOK_ID, Book.class)
                .flatMap(book -> {
                    book.setTitle(EXPECTED_BOOK_TITLE);
                    return bookRepository.save(book); })
                .as(StepVerifier::create)
                .assertNext(book -> {
                    assertNotNull(book);
                    assertEquals(BOOK_ID, book.getId());
                    assertEquals(EXPECTED_BOOK_TITLE, book.getTitle());
                })
                .verifyComplete();
    }

    @DirtiesContext
    @Test
    void deleteBook_success() {
        reactiveMongoTemplate.findById(BOOK_ID, Book.class)
                .as(StepVerifier::create)
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
        bookRepository.deleteById(BOOK_ID)
                .as(StepVerifier::create)
                .verifyComplete();
        reactiveMongoTemplate.findById(BOOK_ID, Book.class)
                .as(StepVerifier::create)
                .verifyComplete();
    }
}