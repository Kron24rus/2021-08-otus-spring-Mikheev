package com.mikheev.homework.controller;

import com.mikheev.homework.controller.model.BookModel;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.CommentService;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final CommentService commentService;

    @GetMapping("/book")
    public List<Book> bookList() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public BookModel getBook(@PathVariable("id") String id) {
        Book book = bookService.getBookWithAllAssociations(id);
        List<Comment> bookComments = commentService.getBookComments(id);
        return new BookModel(book, bookComments);
    }

    @GetMapping("/book/associations")
    public Map<String, Object> loadEditCreateAssociations() {
        Map<String, Object> responseMap = new HashMap<>();
        List<Author> authors = authorService.getAllAuthors();
        List<Genre> genres = genreService.getAllGenres();
        responseMap.put("authors", authors);
        responseMap.put("genres", genres);
        return responseMap;
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") String id) {
        bookService.deleteBook(id);
    }
}
