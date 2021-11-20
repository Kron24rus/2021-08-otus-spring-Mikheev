package com.mikheev.homework.controller;

import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class BookController {

   private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
   private final CommentRepository commentRepository;
   private final ModelMapper modelMapper;

//    @GetMapping("/book")
//    public Flux<BookDto> bookList() {
//        return bookRepository.findAll().map(book -> modelMapper.map(book, BookDto.class));
//    }
//
//    @GetMapping("/book/{id}")
//    public Mono<BookDto> getBook(@PathVariable("id") String id) {
//        Mono<BookDto> bookMono = bookRepository.findById(id).map(book -> modelMapper.map(book, BookDto.class));
//        Mono<List<CommentDto>> commentsMono = commentRepository.findByBookId(id)
//                .map(comment -> modelMapper.map(comment, CommentDto.class)).collectList();
//        return Mono.zip(bookMono, commentsMono, this::appendComments);
//    }
//
//    @GetMapping("/associations")
//    public Mono<AssociationsDto> loadEditCreateAssociations() {
//        Mono<List<AuthorDto>> authors = authorRepository.findAll()
//                .map(author -> modelMapper.map(author, AuthorDto.class)).collectList();
//        Mono<List<GenreDto>> genres = genreRepository.findAll()
//                .map(genre -> modelMapper.map(genre, GenreDto.class)).collectList();
//        return Mono.zip(authors, genres, this::toAssociationsDto);
//    }
//
//    @PostMapping("/book")
//    public Mono<BookDto> addBook(@RequestBody BookDto bookDto) {
//        return bookRepository.insert(modelMapper.map(bookDto, Book.class))
//                .map(book -> modelMapper.map(book, BookDto.class));
//    }
//
//    @PutMapping("/book")
//    public Mono<BookDto> updateBook(@RequestBody BookDto bookDto) {
//        return bookRepository.save(modelMapper.map(bookDto, Book.class))
//                .map(book -> modelMapper.map(book, BookDto.class));
//    }
//
//    @DeleteMapping("/book/{id}")
//    public void deleteBook(@PathVariable("id") String id) {
//        bookRepository.deleteByIdCascadeComments(id);
//    }
//
//    private BookDto appendComments(BookDto book, List<CommentDto> comments) {
//        book.setComments(comments);
//        return book;
//    }
//
//    private AssociationsDto toAssociationsDto(List<AuthorDto> authors, List<GenreDto> genres) {
//        return new AssociationsDto(authors, genres);
//    }
}
