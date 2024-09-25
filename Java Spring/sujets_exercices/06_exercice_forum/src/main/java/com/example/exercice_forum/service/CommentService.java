package com.example.exercice_forum.service;

import com.example.exercice_forum.dao.CommentRepository;
import com.example.exercice_forum.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements IService<Comment> {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment add(Comment element) {
        return commentRepository.save(element);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment update(Comment element) {
        return commentRepository.save(element);
    }
}
