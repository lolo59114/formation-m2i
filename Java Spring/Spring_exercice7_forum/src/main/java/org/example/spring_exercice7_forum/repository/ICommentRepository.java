package org.example.spring_exercice7_forum.repository;

import org.example.spring_exercice7_forum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
