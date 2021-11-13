package com.mikheev.homework.repositories.impl;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.repositories.CommentRepository;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("Tests for comment repository")
class CommentRepositoryImplTest extends AbstractTestRepository {

    private static final String  EXPECTED_BOOK_ID = "0";
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
                .allMatch(comment -> comment.getText().equals(EXPECTED_COMMENT_TEXT))
                .allMatch(comment -> comment.getBook().getId().equals(EXPECTED_BOOK_ID));
    }

    @Test
    void findCommentsByBookId_wrongBookId() {
        val comments = commentRepository.findByBookId(NOT_EXISTING_BOOK_ID);
        assertThat(comments).isEmpty();
    }

    @DirtiesContext
    @Test
    void save_newCommentSaved() {
        Book book = mongoTemplate.findById(EXPECTED_BOOK_ID, Book.class);
        Comment newComment = new Comment();
        newComment.setId(EXPECTED_NEW_COMMENT_ID);
        newComment.setText(EXPECTED_COMMENT_TEXT);
        newComment.setBook(book);
        Comment savedComment = commentRepository.save(newComment);
        Comment expectedComment = mongoTemplate.findById(EXPECTED_NEW_COMMENT_ID, Comment.class);
        assertThat(savedComment).usingRecursiveComparison().isEqualTo(expectedComment);
    }

    @DirtiesContext
    @Test
    void save_updateCommentSuccess() {
        Comment comment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        assertThat(comment.getText()).isEqualTo(EXPECTED_COMMENT_TEXT);

        comment.setText(UPDATED_COMMENT_TEXT);

        commentRepository.save(comment);

        Comment updatedComment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        assertThat(updatedComment.getText()).isEqualTo(UPDATED_COMMENT_TEXT);
    }

    @DirtiesContext
    @Test
    void deleteById_success() {
        Comment comment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        assertThat(comment).isNotNull();

        commentRepository.deleteById(EXPECTED_COMMENT_ID);

        Comment expectedNullComment = mongoTemplate.findById(EXPECTED_COMMENT_ID, Comment.class);
        assertThat(expectedNullComment).isNull();
    }
}
