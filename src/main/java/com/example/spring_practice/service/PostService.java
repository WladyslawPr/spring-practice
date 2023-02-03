package com.example.spring_practice.service;

import com.example.spring_practice.model.Post;
import com.example.spring_practice.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post getSinglePost (long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
