package com.mikheev.homework.service.impl;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.exception.NotFoundException;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.GenreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@Import(BookServiceImpl.class)
class BookServiceImplTest {

    private static final String ENTITY_ID = "153";
    private static final String ENTITY_NAME = "entityName";
    private static final String NEW_ENTITY_NAME = "newEntityName";
    private static final String AUTHOR_ID = "145";
    private static final String NEW_AUTHOR_ID = "255";
    private static final String GENRE_ID = "22";
    private static final String NEW_GENRE_ID = "33";

    @MockBean
    private BookRepository bookRepository;
    @MockBean
    private AuthorRepository authorRepository;
    @MockBean
    private GenreRepository genreRepository;

    @Autowired
    private BookServiceImpl bookService;

    @Test
    void getAllBooks() {
        bookService.getAllBooks();
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void getBookWithId() {
        Book book = new Book();
        book.setTitle(ENTITY_NAME);
        book.setId(ENTITY_ID);
        Optional<Book> optionalBook = Optional.of(book);
        when(bookRepository.findByIdWithComments(ENTITY_ID)).thenReturn(optionalBook);
        Book foundBook = bookService.getBookWithAllAssociations(ENTITY_ID);
        assertThat(foundBook).isEqualTo(book);
    }


    @Test
    void addBook_messageWithCorrectIdReturned() {
        Author author = new Author();
        author.setId(AUTHOR_ID);
        Genre genre = new Genre();
        genre.setId(GENRE_ID);
        Optional<Author> optionalAuthor = Optional.of(author);
        Optional<Genre> optionalGenre = Optional.of(genre);
        Book newBook = new Book(ENTITY_NAME, author, genre);
        Book savedBook = new Book(ENTITY_NAME, author, genre);
        savedBook.setId(ENTITY_ID);
        when(authorRepository.findById(AUTHOR_ID)).thenReturn(optionalAuthor);
        when(genreRepository.findById(GENRE_ID)).thenReturn(optionalGenre);
        when(bookRepository.save(newBook)).thenReturn(savedBook);
        bookService.addBook(newBook);
        verify(bookRepository, times(1)).save(newBook);
    }

    @Test
    void addBook_notSavedWrongAuthorId() {
        Author author = new Author();
        author.setId(AUTHOR_ID);
        Genre genre = new Genre();
        Optional<Genre> optionalGenre = Optional.of(genre);
        when(authorRepository.findById(AUTHOR_ID)).thenReturn(Optional.empty());
        when(genreRepository.findById(GENRE_ID)).thenReturn(optionalGenre);
        Book newBook = new Book(ENTITY_NAME, author, genre);
        Exception exception = assertThrows(NotFoundException.class, () -> bookService.addBook(newBook));
        assertThat(exception.getMessage()).isEqualTo("Author with id " + AUTHOR_ID + " not found!");
    }

    @Test
    void deleteBook_messageWithCorrectIdReturned() {
        bookService.deleteBook(ENTITY_ID);
        verify(bookRepository, times(1)).deleteByIdCascadeComments(ENTITY_ID);
    }

    @Test
    void updateBook_verifyThatBookEntityUpdated() {
        Book databaseBook = new Book();
        Book bookWithUpdates = new Book();
        Genre genre = new Genre();
        genre.setId(GENRE_ID);
        Author author = new Author();
        author.setId(AUTHOR_ID);
        Author newAuthor = new Author();
        newAuthor.setId(NEW_AUTHOR_ID);
        Genre newGenre = new Genre();
        newGenre.setId(NEW_GENRE_ID);
        databaseBook.setId(ENTITY_ID);
        databaseBook.setTitle(ENTITY_NAME);
        databaseBook.setGenre(genre);
        databaseBook.setAuthor(author);
        bookWithUpdates.setId(ENTITY_ID);
        bookWithUpdates.setTitle(NEW_ENTITY_NAME);
        bookWithUpdates.setAuthor(newAuthor);
        bookWithUpdates.setGenre(newGenre);
        Optional<Book> optionalBook = Optional.of(databaseBook);
        Optional<Author> optionalAuthor = Optional.of(newAuthor);
        Optional<Genre> optionalGenre = Optional.of(newGenre);
        when(bookRepository.findById(ENTITY_ID)).thenReturn(optionalBook);
        when(authorRepository.findById(NEW_AUTHOR_ID)).thenReturn(optionalAuthor);
        when(genreRepository.findById(NEW_GENRE_ID)).thenReturn(optionalGenre);
        when(bookRepository.save(databaseBook)).thenReturn(databaseBook);
        Book updatedBook = bookService.updateBook(bookWithUpdates);
        verify(bookRepository, times(1)).save(databaseBook);
        assertThat(databaseBook.getTitle()).isEqualTo(updatedBook.getTitle());
    }
}
