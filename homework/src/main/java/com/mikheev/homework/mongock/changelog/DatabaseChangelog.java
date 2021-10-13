package com.mikheev.homework.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import com.mikheev.homework.repositories.GenreRepository;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDatabase", author = "AlexanderMikheev", runAlways = true)
    public void dropDatabase(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "002", id = "insertData", author = "AlexanderMikheev", runAlways = true)
    public void insertData(GenreRepository genreRepository, AuthorRepository authorRepository,
                           BookRepository bookRepository, CommentRepository commentRepository) {

        Genre detectiveGenre = new Genre("0", "detective");
        Genre comedyGenre = new Genre("1", "comedy");
        Genre criminalGenre = new Genre("2", "criminal");
        Genre fantasyGenre = new Genre("3", "fantasy");
        genreRepository.saveAll(Arrays.asList(detectiveGenre, comedyGenre, criminalGenre, fantasyGenre));

        Author author0 = new Author("0", "AuthorOfDetectiveAndComedy");
        Author author1 = new Author("1", "TalentedAuthor");
        Author author2 = new Author("2", "BadAndBoringAuthor");
        authorRepository.saveAll(Arrays.asList(author0, author1, author2));

        Book book0 = new Book("0", "comedyBook", author0, comedyGenre);
        Book book1 = new Book("1", "detectiveBook", author0, detectiveGenre);
        Book book2 = new Book("2", "criminalBook", author1, criminalGenre);
        Book book3 = new Book("3", "fantasyBook", author1, fantasyGenre);
        Book book4 = new Book("4", "criminalBookOfBadAuthor", author2, criminalGenre);
        Book book5 = new Book("5", "criminalBookOfTalented", author1, criminalGenre);
        Book book6 = new Book("6", "detectiveOfBadAuthor", author2, detectiveGenre);
        Book book7 = new Book("7", "comedyOfBoringAuthor", author2, comedyGenre);
        bookRepository.saveAll(Arrays.asList(book0, book1, book2, book3, book4, book5, book6, book7));

        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("1", "positive comment", book0));
        comments.add(new Comment("2", "negative comment", book1));
        comments.add(new Comment("3", "neutral comment", book2));
        comments.add(new Comment("4", "positive comment2", book0));
        comments.add(new Comment("5", "negative comment2", book1));
        comments.add(new Comment("6", "neutral comment2", book2));
        comments.add(new Comment("7", "positive comment3", book0));
        comments.add(new Comment("8", "negative comment3", book1));
        comments.add(new Comment("9", "neutral comment3", book2));
        comments.add(new Comment("10", "positive comment4", book0));
        comments.add(new Comment("11", "negative comment4", book1));
        comments.add(new Comment("12", "neutral comment4", book2));
        comments.add(new Comment("13", "positive comment5", book0));
        comments.add(new Comment("14", "negative comment5", book1));
        comments.add(new Comment("15", "neutral comment5", book2));
        comments.add(new Comment("16", "positive comment6", book0));
        comments.add(new Comment("17", "negative comment6", book1));
        comments.add(new Comment("18", "neutral comment6", book2));
        comments.add(new Comment("19", "positive comment7", book0));
        comments.add(new Comment("20", "negative comment7", book1));
        comments.add(new Comment("21", "neutral comment7", book2));
        comments.add(new Comment("22", "positive comment8", book0));
        comments.add(new Comment("23", "negative comment8", book1));
        comments.add(new Comment("24", "neutral comment8", book2));
        comments.add(new Comment("25", "positive comment", book3));
        comments.add(new Comment("26", "negative comment", book4));
        comments.add(new Comment("27", "neutral comment", book5));
        comments.add(new Comment("28", "positive comment", book6));
        comments.add(new Comment("29", "negative comment", book7));
        commentRepository.saveAll(comments);
    }
}
