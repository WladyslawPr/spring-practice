package com.example.spring_practice.controller.rest;

import com.example.spring_practice.dto.PostDTO;
import com.example.spring_practice.mapper.PostDTOMapper;
import com.example.spring_practice.model.Post;
import com.example.spring_practice.service.PostService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/posts/{id}"})
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);
    }

    @GetMapping("/posts")
    public List<PostDTO> getPosts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return PostDTOMapper.mapToPostDTOs(postService.getPosts(pageNumber, sortDirection));
    }
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }
    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }
    @GetMapping("/posts/comments")
    public List<Post> getPostWithComment(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPostsWithComments(pageNumber, sortDirection);
    }
}
