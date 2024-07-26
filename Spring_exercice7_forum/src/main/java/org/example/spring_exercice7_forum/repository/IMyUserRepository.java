package org.example.spring_exercice7_forum.repository;

import org.example.spring_exercice7_forum.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsernameAndPassword(String username, String password);

    MyUser findByUsername(String username);
}
