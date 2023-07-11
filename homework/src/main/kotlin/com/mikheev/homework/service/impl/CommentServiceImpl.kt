package com.mikheev.homework.service.impl

import com.mikheev.homework.domain.Book
import com.mikheev.homework.domain.Comment
import com.mikheev.homework.exception.NotFoundException
import com.mikheev.homework.repositories.BookRepository
import com.mikheev.homework.repositories.CommentRepository
import com.mikheev.homework.service.CommentService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val bookRepository: BookRepository) : CommentService {

    @Transactional
    override fun addComment(bookId: Long, comment: Comment): Comment {
        val book: Book = bookRepository.findById(bookId)
            .orElseThrow { NotFoundException("Book with id $bookId not found!") }
        comment.book = book
        return commentRepository.save(comment)
    }

    @Transactional
    override fun updateComment(comment: Comment): Comment {
        val databaseComment: Comment = commentRepository.findById(comment.id)
            .orElseThrow { NotFoundException("Comment with id ${comment.id} not found!") }
        databaseComment.text = comment.text
        return commentRepository.save(databaseComment)
    }

    @Transactional
    override fun deleteComment(commentId: Long) {
        commentRepository.deleteById(commentId)
    }
}