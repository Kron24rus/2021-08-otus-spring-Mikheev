package com.mikheev.homework.mongocktest;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.domain.Genre;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ChangeLog
public class TestDatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDatabase", author = "AlexanderMikheev", runAlways = true)
    public void dropDatabase(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "002", id = "insertData", author = "AlexanderMikheev", runAlways = true)
    public void insertData(MongockTemplate mongoTemplate) {

        Genre detectiveGenre = new Genre("0", "detective");
        Genre comedyGenre = new Genre("1", "comedy");
        Genre criminalGenre = new Genre("2", "criminal");
        mongoTemplate.insertAll(Arrays.asList(detectiveGenre, comedyGenre, criminalGenre));

        Author author0 = new Author("0", "AuthorOfDetectiveAndComedy");
        mongoTemplate.insertAll(Collections.singletonList(author0));

        Book book0 = new Book("0", "comedyBook", author0, comedyGenre);
        Book book1 = new Book("1", "detectiveBook", author0, detectiveGenre);
        Book book2 = new Book("2", "criminalBook", author0, criminalGenre);
        mongoTemplate.insertAll(Arrays.asList(book0, book1, book2));

        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("1", "test positive comment", book0));
        comments.add(new Comment("2", "test negative comment", book1));
        comments.add(new Comment("3", "test neutral comment", book2));
        comments.add(new Comment("4", "test positive comment", book0));
        mongoTemplate.insertAll(comments);
    }
}
