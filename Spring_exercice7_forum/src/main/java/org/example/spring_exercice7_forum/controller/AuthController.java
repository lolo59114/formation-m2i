package org.example.spring_exercice7_forum.controller;

import jakarta.servlet.http.HttpSession;
import org.example.spring_exercice7_forum.entity.MyUser;
import org.example.spring_exercice7_forum.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    private final AuthService authService;
    private HttpSession session;

    public AuthController(AuthService authService, HttpSession session) {
        this.authService = authService;
        this.session = session;
    }

    @GetMapping
    public String home(Model model) {
        if(authService.isLogged()){
            model.addAttribute("user", authService.getUser());
            return "home";
        } else {
            model.addAttribute("user", new MyUser());
            return "login";
        }
    }
}
