package org.example.spring_exercice7_forum.repository;

import org.example.spring_exercice7_forum.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
}
