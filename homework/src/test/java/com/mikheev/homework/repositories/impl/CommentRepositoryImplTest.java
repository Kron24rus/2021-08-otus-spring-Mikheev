package com.mikheev.homework.repositories.impl;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.CommentRepository;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Tests for comment repository")
@DataMongoTest
class CommentRepositoryImplTest extends AbstractTestRepository {

    private static final String EXPECTED_BOOK_ID = "0";
    private static final String NOT_EXISTING_BOOK_ID = "145";
    private static final String EXPECTED_COMMENT_TEXT = "test positive comment";
    private static final String UPDATED_COMMENT_TEXT = "updated comment";
    private static final String EXPECTED_COMMENT_ID = "1";
    private static final int EXPECTED_NUMBER_OF_COMMENTS = 2;
    private static final String EXPECTED_NEW_COMMENT_ID = "5";

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void findCommentsByBookId_success() {
        val comments = commentRepository.findByBookId(EXPECTED_BOOK_ID);
        assertThat(comments).isNotNull().hasSize(EXPECTED_NUMBER_OF_COMMENTS)
                .allMatch(comment -> comment.getText().equals(EXPECTED_COMMENT_TEXT));
    }

    @Test
    void findCommentsByBookId_wrongBookId() {
        val comments = commentRepository.findByBookId(NOT_EXISTING_BOOK_ID);
        assertThat(comments).isEmpty();
    }

    @Test
    void save_newCommentSaved() {
        Book book = mongoTemplate.findById(EXPECTED_BOOK_ID, Book.class);
        Comment newComment = new Comment();
        newComment.setId(EXPECTED_NEW_COMMENT_ID);
        newComment.setText(EXPECTED_COMMENT_TEXT);
        newComment.setBook(book);
        Comment savedComment = commentRepository.save(newComment);
        Comment expectedComment = mongoTemplate.findById(EXPECTED_NEW_COMMENT_ID, Comment.class);
        Assertions.assertThat(savedComment).usingRecursiveComparison().isEqualTo(expectedComment);
    }

    @Test
    void save_updateCommentSuccess() {
        Comment comment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        AssertionsForClassTypes.assertThat(comment.getText()).isEqualTo(EXPECTED_COMMENT_TEXT);

        comment.setText(UPDATED_COMMENT_TEXT);

        commentRepository.save(comment);

        Comment updatedComment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        AssertionsForClassTypes.assertThat(updatedComment.getText()).isEqualTo(UPDATED_COMMENT_TEXT);
    }

    @Test
    void deleteById_success() {
        Comment comment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        Assertions.assertThat(comment).isNotNull();

        commentRepository.deleteById(EXPECTED_COMMENT_ID);

        Comment expectedNullComment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        Assertions.assertThat(expectedNullComment).isNull();
    }
}
