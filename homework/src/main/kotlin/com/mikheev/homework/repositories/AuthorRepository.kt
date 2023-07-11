package com.mikheev.homework.repositories

import com.mikheev.homework.domain.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>
