package com.mikheev.homework.service

import com.mikheev.homework.domain.Comment

interface CommentService {

    fun addComment(bookId: Long, comment: Comment): Comment
    fun updateComment(comment: Comment): Comment
    fun deleteComment(commentId: Long)
}