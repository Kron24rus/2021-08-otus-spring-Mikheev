package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/addcomment")
    public String addCommentPage(@RequestParam("bookId") long bookId, Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("bookId", bookId);
        return "addcomment";
    }

    @PostMapping("addcomment")
    public String addComment(@RequestParam("bookId") long bookId, Comment comment, Model model) {
        commentService.addComment(bookId, comment);
        return "redirect:/bookpage?id=" + bookId;
    }

    @GetMapping("/editcomment")
    public String editCommentPage(@RequestParam("bookId") long bookId, Comment comment, Model model) {
        model.addAttribute("comment", comment);
        model.addAttribute("bookId", bookId);
        return "editcomment";
    }

    @PostMapping("/editcomment")
    public String editComment(@RequestParam("bookId") long bookId, Comment comment, Model model) {
        commentService.updateComment(comment);
        return "redirect:/bookpage?id=" + bookId;
    }

    @PostMapping("/deletecomment")
    public String deleteComment(@RequestParam("id") long id,
                                @RequestParam("bookId") long bookId, Model model) {
        commentService.deleteComment(id);
        return "redirect:/bookpage?id=" + bookId;
    }
}
