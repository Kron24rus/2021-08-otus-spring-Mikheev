package com.mikheev.homework.repositories.impl;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.BookRepository;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Tests for book repository")
class BookRepositoryImplTest extends AbstractTestRepository {

    private static final String BOOK_ID = "1";
    private static final int EXPECTED_NUMBER_OF_BOOKS = 3;
    private static final String EXPECTED_BOOK_TITLE = "expectedBookTitle";
    private static final String EXPECTED_BOOK_ID = "3";
    private static final String GENRE_DETECTIVE = "detective";
    private static final String GENRE_COMEDY_ID = "1";
    private static final String BOOK_TITLE_DETECTIVE = "detectiveBook";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void findById_validBook() {
        val optionalFoundBook = bookRepository.findById(BOOK_ID);
        val expectedBook = mongoTemplate.findById(BOOK_ID, Book.class);
        assertThat(optionalFoundBook).isPresent().get().usingRecursiveComparison().isEqualTo(expectedBook);
    }

    @Test
    void findById_notFound() {
        val optionalNotFoundBook = bookRepository.findById(EXPECTED_BOOK_ID);
        assertThat(optionalNotFoundBook.isEmpty()).isTrue();
    }

    @Test
    void findAllBooks_containsAllBooksWithAuthorAndGenre() {
        val books = bookRepository.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(book -> !book.getTitle().isEmpty())
                .allMatch(book -> book.getAuthor() != null)
                .allMatch(book -> book.getGenre() != null);
    }

    @DirtiesContext
    @Test
    void saveBook_newBookSaved() {
        Author author = mongoTemplate.findById("0", Author.class);
        Genre genre =  mongoTemplate.findById("0", Genre.class);
        Book newBook = new Book();
        newBook.setId(EXPECTED_BOOK_ID);
        newBook.setTitle(EXPECTED_BOOK_TITLE);
        newBook.setAuthor(author);
        newBook.setGenre(genre);
        Book savedBook = bookRepository.save(newBook);
        Book expectedBook = mongoTemplate.findById(EXPECTED_BOOK_ID, Book.class);
        assertThat(savedBook).usingRecursiveComparison().isEqualTo(expectedBook);
    }

    @DirtiesContext
    @Test
    void saveBook_bookUpdated() {
        Book book = mongoTemplate.findById(BOOK_ID, Book.class);
        assertThat(book.getGenre().getName()).isEqualTo(GENRE_DETECTIVE);
        assertThat(book.getTitle()).isEqualTo(BOOK_TITLE_DETECTIVE);

        Genre genre = mongoTemplate.findById(GENRE_COMEDY_ID, Genre.class);
        book.setTitle(EXPECTED_BOOK_TITLE);
        book.setGenre(genre);

        bookRepository.save(book);
        Book savedBook = mongoTemplate.findById(BOOK_ID, Book.class);

        assertThat(savedBook.getTitle()).isEqualTo(EXPECTED_BOOK_TITLE);
        assertThat(savedBook.getGenre()).usingRecursiveComparison().isEqualTo(genre);
        assertThat(savedBook.getId()).isEqualTo(BOOK_ID);
    }

    @DirtiesContext
    @Test
    void deleteBook_success() {
        Book book = mongoTemplate.findById(BOOK_ID, Book.class);
        assertThat(book).isNotNull();

        bookRepository.deleteByIdCascadeComments(BOOK_ID);

        Book expectedNullBook = mongoTemplate.findById(BOOK_ID, Book.class);
        assertThat(expectedNullBook).isNull();
    }
}
