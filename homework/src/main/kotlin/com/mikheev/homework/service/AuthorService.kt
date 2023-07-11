package com.mikheev.homework.service

import com.mikheev.homework.domain.Author

interface AuthorService {

    fun getAllAuthors(): List<Author>
}