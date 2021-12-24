package com.mikheev.homework.repositories.impl;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.repositories.BookCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Book> findById(long id, String entityGraphName) {
        EntityGraph entityGraph = em.getEntityGraph(entityGraphName);
        return Optional.ofNullable(em.find(Book.class, id, Map.of("javax.persistence.fetchgraph", entityGraph)));
    }
}
