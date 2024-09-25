package com.example.exercice_forum.service;

import com.example.exercice_forum.dao.UserRepository;
import com.example.exercice_forum.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService{
    private final UserRepository userRepository;
    @Autowired
    private HttpSession _httpSession;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user.getPassword().equals(password)) {
            _httpSession.setAttribute("user", user);
            _httpSession.setAttribute("login", "OK");
            return true;
        }
        return false;
    }

    @Override
    public boolean isLogged() {
        try {
            String attrIsLogged = _httpSession.getAttribute("login").toString();
            return attrIsLogged.equals("OK");
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deconnexion() {
        _httpSession.removeAttribute("user");
        _httpSession.removeAttribute("login");
    }
}
