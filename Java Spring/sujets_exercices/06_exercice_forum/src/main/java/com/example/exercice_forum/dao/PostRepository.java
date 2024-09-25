package com.example.exercice_forum.dao;

import com.example.exercice_forum.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
