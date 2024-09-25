package com.example.exercice_forum.dao;

import com.example.exercice_forum.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
