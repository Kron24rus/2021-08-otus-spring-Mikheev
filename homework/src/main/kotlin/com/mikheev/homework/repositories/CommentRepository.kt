package com.mikheev.homework.repositories

import com.mikheev.homework.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {

    fun findByBookId(bookId: Long): List<Comment>
}