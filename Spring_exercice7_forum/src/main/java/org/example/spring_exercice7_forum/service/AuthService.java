package org.example.spring_exercice7_forum.service;

import jakarta.servlet.http.HttpSession;
import org.example.spring_exercice7_forum.entity.MyUser;
import org.example.spring_exercice7_forum.repository.IMyUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final IMyUserRepository userRepository;
    private final HttpSession session;
    public AuthService(HttpSession session, IMyUserRepository userRepository) {
        this.session = session;
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        MyUser user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            session.setAttribute("isLoggedIn", true);
        }
        return user != null;
    }

    public boolean isLogged() {
        try {
            String user = (String) session.getAttribute("user");
            return (boolean) session.getAttribute("isLoggedIn");
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        session.setAttribute("isLoggedIn", false);
    }

    public boolean register(String username, String password) {
        MyUser user = userRepository.findByUsername(username);
        if (user != null) {
            return false;
        } else {
            user = new MyUser();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
        }
        return true;
    }

    public MyUser getUser() {
        return userRepository.findByUsername((String) session.getAttribute("user"));
    }
}
