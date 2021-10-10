package com.mikheev.homework.shell;

import com.mikheev.homework.service.CommentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class LibraryApplicationCommentCommands {

    private CommentService commentService;

    public LibraryApplicationCommentCommands(CommentService commentService) {
        this.commentService = commentService;
    }

    @ShellMethod(value = "Display book comments", key = {"getcomments"})
    public String displayBookComments(String id) {
        return commentService.getAllBookCommentsAsString(id);
    }

    @ShellMethod(value = "Add new comment to book", key = {"addcomment"})
    public String addNewComment(String bookId, String text) {
        return commentService.addComment(bookId, text);
    }

    @ShellMethod(value = "Update comment text", key = {"updatecomment"})
    public String updateComment(String commentId, String text) {
        return commentService.updateComment(commentId, text);
    }

    @ShellMethod(value = "Delete comment", key = {"deletecomment"})
    public String deleteComment(String commentId) {
        return commentService.deleteComment(commentId);
    }

    @ShellMethod(value = "Copy comment", key = {"copycomment"})
    public String copyComment(String commentId, String bookId) {
        return commentService.copyComment(commentId, bookId);
    }
}
