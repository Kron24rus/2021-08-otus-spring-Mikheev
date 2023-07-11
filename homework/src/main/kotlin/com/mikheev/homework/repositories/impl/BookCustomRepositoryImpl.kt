package com.mikheev.homework.repositories.impl

import com.mikheev.homework.domain.Book
import com.mikheev.homework.repositories.BookCustomRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BookCustomRepositoryImpl : BookCustomRepository {

    @PersistenceContext
    lateinit var em: EntityManager

    override fun findById(id: Long, entityGraphName: String): Optional<Book> {
        val entityGraph = em.getEntityGraph(entityGraphName)
        return Optional.ofNullable(em.find(Book::class.java, id, mapOf("jakarta.persistence.fetchgraph" to entityGraph)))
    }
}