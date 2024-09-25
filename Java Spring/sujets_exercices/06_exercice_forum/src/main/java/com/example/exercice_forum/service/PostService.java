package com.example.exercice_forum.service;

import com.example.exercice_forum.dao.PostRepository;
import com.example.exercice_forum.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IService<Post> {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post add(Post element) {
        return postRepository.save(element);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post update(Post element) {
        return postRepository.save(element);
    }
}
