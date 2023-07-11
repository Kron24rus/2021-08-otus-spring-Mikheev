package com.mikheev.homework.repositories

import com.mikheev.homework.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>, BookCustomRepository
