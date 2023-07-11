package com.mikheev.homework.service.impl

import com.mikheev.homework.domain.Author
import com.mikheev.homework.repositories.AuthorRepository
import com.mikheev.homework.service.AuthorService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {

    @Transactional(readOnly = true)
    override fun getAllAuthors(): List<Author> {
        return authorRepository.findAll()
    }
}