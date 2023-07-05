package com.mikheev.homework.domain;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"comments"})
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "book-with-all-associations",
                attributeNodes = {
                        @NamedAttributeNode("author"),
                        @NamedAttributeNode("genre"),
                        @NamedAttributeNode("comments")
                }),
        @NamedEntityGraph(
                name = "book-with-author-genre",
                attributeNodes = {
                        @NamedAttributeNode("author"),
                        @NamedAttributeNode("genre")
                }
        )
})
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(targetEntity = Author.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(targetEntity = Genre.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> comments;

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
