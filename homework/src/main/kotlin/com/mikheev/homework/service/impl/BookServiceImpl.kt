package com.mikheev.homework.service.impl

import com.mikheev.homework.domain.Author
import com.mikheev.homework.domain.Book
import com.mikheev.homework.domain.Genre
import com.mikheev.homework.exception.NotFoundException
import com.mikheev.homework.repositories.AuthorRepository
import com.mikheev.homework.repositories.BookRepository
import com.mikheev.homework.repositories.GenreRepository
import com.mikheev.homework.service.BookService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
    private val genreRepository: GenreRepository) : BookService {

    @Transactional(readOnly = true)
    override fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    @Transactional(readOnly = true)
    override fun getBookWithAllAssociations(id: Long): Book {
        return bookRepository.findById(id, "book-with-all-associations")
            .orElseThrow { NotFoundException("Book with id $id not found") }
    }

    @Transactional
    override fun addBook(book: Book): Book {
        val databaseAuthor: Author = authorRepository.findById(book.author.id!!)
            .orElseThrow { NotFoundException("Author with id ${book.author.id} not found!") }
        val databaseGenre: Genre = genreRepository.findById(book.genre.id!!)
            .orElseThrow { NotFoundException("Genre with id ${book.genre.id} not found!") }
        val bookToSave = Book(book.title, databaseAuthor, databaseGenre)
        return bookRepository.save(bookToSave)
    }

    @Transactional
    override fun updateBook(book: Book): Book {
        val databaseBook: Book = bookRepository.findById(book.id).orElseThrow { NotFoundException() }
        val databaseAuthor: Author = authorRepository.findById(book.author.id!!)
            .orElseThrow { NotFoundException("Author with id ${book.author.id} not found!") }
        val databaseGenre: Genre = genreRepository.findById(book.genre.id!!)
            .orElseThrow { NotFoundException("Genre with id ${book.genre.id} not found!") }
        databaseBook.title = book.title
        databaseBook.author = databaseAuthor
        databaseBook.genre = databaseGenre
        return bookRepository.save(databaseBook)
    }

    @Transactional
    override fun deleteBook(id: Long) {
        bookRepository.deleteById(id)
    }
}
