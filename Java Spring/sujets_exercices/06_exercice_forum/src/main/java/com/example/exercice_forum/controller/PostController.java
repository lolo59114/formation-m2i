package com.example.exercice_forum.controller;

import com.example.exercice_forum.entities.Comment;
import com.example.exercice_forum.entities.Post;
import com.example.exercice_forum.entities.User;
import com.example.exercice_forum.service.AuthServiceImpl;
import com.example.exercice_forum.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class PostController {
    private final PostService postService;
    private final AuthServiceImpl authService;

    public PostController(PostService postService, AuthServiceImpl authService) {
        this.postService = postService;
        this.authService = authService;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        if (authService.isLogged()) {
            model.addAttribute("login", authService.isLogged());
            model.addAttribute("posts", postService.getAll());
            model.addAttribute("user", (User) session.getAttribute("user"));
            model.addAttribute("comment", new Comment());
            return "home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/postForm")
    public String postForm(Model model) {
        if (authService.isLogged()) {
            model.addAttribute("post", new Post());
            model.addAttribute("login", authService.isLogged());
            return "post-form";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/post/add")
    public String addPost(@ModelAttribute("post") Post post, HttpSession session) {
        if (authService.isLogged()) {
            post.setAuthor((User) session.getAttribute("user"));
            post.setCreatedAt(LocalDateTime.now());
            postService.add(post);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/post/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        if (authService.isLogged()) {
            model.addAttribute("post", postService.getById(id));
            return "post-form";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        if (authService.isLogged()) {
            postService.delete(id);
        return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}
