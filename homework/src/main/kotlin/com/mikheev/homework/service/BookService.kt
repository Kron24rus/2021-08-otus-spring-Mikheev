package com.mikheev.homework.service

import com.mikheev.homework.domain.Book

interface BookService {

    fun getAllBooks(): List<Book>
    fun getBookWithAllAssociations(id: Long): Book
    fun addBook(book: Book): Book
    fun updateBook(book: Book): Book
    fun deleteBook(id: Long)
}
