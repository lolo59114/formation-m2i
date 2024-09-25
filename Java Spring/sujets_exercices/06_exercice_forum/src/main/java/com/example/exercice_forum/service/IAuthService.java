package com.example.exercice_forum.service;

import com.example.exercice_forum.entities.User;

public interface IAuthService {
    boolean login(String username, String password);
    boolean isLogged();
    User register(User user);
    void deconnexion();
}
