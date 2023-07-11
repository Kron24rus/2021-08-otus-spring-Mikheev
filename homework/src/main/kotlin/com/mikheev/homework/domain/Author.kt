package com.mikheev.homework.domain

import jakarta.persistence.*

@Entity
@Table(name = "authors")
class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name")
    val name: String? = null
}
