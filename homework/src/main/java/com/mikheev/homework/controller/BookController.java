package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.*;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/associations")
    public AssociationsDto loadEditCreateAssociations() {
        List<AuthorDto> authors = authorService.getAllAuthors().stream()
                .map(author -> modelMapper.map(author, AuthorDto.class)).collect(Collectors.toList());
        List<GenreDto> genres = genreService.getAllGenres().stream()
                .map(genre -> modelMapper.map(genre, GenreDto.class)).collect(Collectors.toList());
        return new AssociationsDto(authors, genres);
    }

    @PostMapping("/book")
    public BookDto addBook(@RequestBody Book book) {
        return modelMapper.map(bookService.addBook(book), BookDto.class);
    }

    @PutMapping("/book")
    public BookDto updateBook(@RequestBody Book book) {
        return modelMapper.map(bookService.updateBook(book), BookDto.class);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
    }
}
