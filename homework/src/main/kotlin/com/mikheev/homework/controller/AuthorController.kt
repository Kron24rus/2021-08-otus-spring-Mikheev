package com.mikheev.homework.controller

import com.mikheev.homework.domain.Author
import com.mikheev.homework.service.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/library")
class AuthorController(val authorService: AuthorService) {

    @GetMapping("/author")
    fun authorList(): List<Author> {
        return authorService.getAllAuthors()
    }
}
