package com.example.exercice_forum.controller;

import com.example.exercice_forum.entities.Comment;
import com.example.exercice_forum.entities.User;
import com.example.exercice_forum.service.AuthServiceImpl;
import com.example.exercice_forum.service.CommentService;
import com.example.exercice_forum.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;
    private final AuthServiceImpl authService;

    public CommentController(CommentService commentService, PostService postService, AuthServiceImpl authService) {
        this.commentService = commentService;
        this.postService = postService;
        this.authService = authService;
    }

    @PostMapping("/addComment/{postId}")
    public String addComment(@PathVariable Long postId, @ModelAttribute("comment") Comment comment, HttpSession session) {
        if (authService.isLogged()) {
            comment.setUser((User) session.getAttribute("user"));
            comment.setPost(postService.getById(postId));
            commentService.add(comment);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable Long id, HttpSession session) {
        if (authService.isLogged()) {
            commentService.delete(id);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/comment/edit/{id}")
    public String editComment(@PathVariable Long id, Model model, HttpSession session) {
        if (authService.isLogged()) {
            model.addAttribute("login", authService.isLogged());
            model.addAttribute("posts", postService.getAll());
            model.addAttribute("user", (User) session.getAttribute("user"));
            model.addAttribute("comment", commentService.getById(id));
            return "home";
        } else {
            return "redirect:/login";
        }
    }
}
