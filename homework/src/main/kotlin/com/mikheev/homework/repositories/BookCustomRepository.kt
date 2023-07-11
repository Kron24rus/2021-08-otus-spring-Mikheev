package com.mikheev.homework.repositories

import com.mikheev.homework.domain.Book
import java.util.Optional

interface BookCustomRepository {

    fun findById(id: Long, entityGraphName: String): Optional<Book>
}