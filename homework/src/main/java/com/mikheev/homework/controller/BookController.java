package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.BookDto;
import com.mikheev.homework.controller.dto.BookListDto;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final ModelMapper modelMapper;

    @GetMapping("/book")
    public List<BookListDto> bookList() {
        return bookService.getAllBooks().stream()
                .map(book -> modelMapper.map(book, BookListDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/book/{id}")
    public BookDto getBook(@PathVariable("id") long id) {
        return modelMapper.map(bookService.getBookWithAllAssociations(id), BookDto.class);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @GetMapping("/associations")
    public Map<String, Object> loadEditCreateAssociations() {
        Map<String, Object> responseMap = new HashMap<>();
        List<Author> authors = authorService.getAllAuthors();
        List<Genre> genres = genreService.getAllGenres();
        responseMap.put("authors", authors);
        responseMap.put("genres", genres);
        return responseMap;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
    }
}
