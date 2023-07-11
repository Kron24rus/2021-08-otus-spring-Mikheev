package com.mikheev.homework.controller

import com.mikheev.homework.controller.dto.*
import com.mikheev.homework.domain.Author
import com.mikheev.homework.domain.Book
import com.mikheev.homework.domain.Genre
import com.mikheev.homework.service.AuthorService
import com.mikheev.homework.service.BookService
import com.mikheev.homework.service.GenreService
import org.modelmapper.ModelMapper
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/library")
class BookController(
    val bookService: BookService,
    val authorService: AuthorService,
    val genreService: GenreService,
    val modelMapper: ModelMapper) {

    @GetMapping("/book")
    fun bookList(): List<BookListDto> {
        return bookService.getAllBooks().stream()
            .map { book: Book -> modelMapper.map(book, BookListDto::class.java) }
            .collect(Collectors.toList())
    }

    @GetMapping("/book/{id}")
    fun getBook(@PathVariable("id") id: Long): BookDto {
        return modelMapper.map(bookService.getBookWithAllAssociations(id), BookDto::class.java)
    }

    @GetMapping("/associations")
    fun loadEditCreateAssociations(): AssociationsDto {
        val authors = authorService.getAllAuthors().stream()
            .map { author: Author -> modelMapper.map(author, AuthorDto::class.java) }
            .collect(Collectors.toList())
        val genres = genreService.getAllGenres().stream()
            .map { genre: Genre -> modelMapper.map(genre, GenreDto::class.java) }
            .collect(Collectors.toList())
        return AssociationsDto(authors, genres)
    }

    @PostMapping("/book")
    fun addBook(@RequestBody book: Book): BookDto {
        return modelMapper.map(bookService.addBook(book), BookDto::class.java)
    }

    @PutMapping("/book")
    fun updateBook(@RequestBody book: Book): BookDto {
        return modelMapper.map(bookService.updateBook(book), BookDto::class.java)
    }

    @DeleteMapping("/book/{id}")
    fun deleteBook(@PathVariable("id") id: Long) {
        bookService.deleteBook(id)
    }
}
