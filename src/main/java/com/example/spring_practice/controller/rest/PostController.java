package com.example.spring_practice.controller.rest;

import com.example.spring_practice.model.Post;
import com.example.spring_practice.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/posts/{id}"})
    public Post getSinglePost(@PathVariable long id) {
        return this.postService.getSinglePost(id);
    }
}
