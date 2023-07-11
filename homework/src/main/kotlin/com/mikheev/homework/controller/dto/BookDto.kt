package com.mikheev.homework.controller.dto

class BookDto {

    var id: Long? = null
    var title: String? = null
    var author: AuthorDto? = null
    var genre: GenreDto? = null
    var comments: List<CommentDto>? = null
}
