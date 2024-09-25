package com.example.exercice_forum.controller;

import com.example.exercice_forum.entities.User;
import com.example.exercice_forum.service.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }


    @GetMapping("/registration")
    public String inscription(Model model) {
        model.addAttribute("user", new User());
        return "registration-form";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {
        authService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("login", authService.isLogged());
        return "connexion-form";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        boolean connected = authService.login(user.getUsername(), user.getPassword());
        if (connected) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/deconnexion")
    public String deconnexion(Model model) {
        authService.deconnexion();
        return "redirect:/login";
    }
}
