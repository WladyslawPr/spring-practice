package com.example.spring_practice.service;

import com.example.spring_practice.model.Post;
import com.example.spring_practice.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {

    private static final int PAGE_SIZE = 3;
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post getSinglePost (long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPosts (int page, Sort.Direction sortDirection) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sortDirection, "id")));
    }

    public Post addPost (Post post) {
        return postRepository.save(post);
    }
    @Transactional
    public Post editPost (Post post) {
        Post postEdited = postRepository.findById(post.getId()).orElseThrow();
        postEdited.setTitle(post.getTitle());
        postEdited.setContent(post.getContent());
        return postEdited;
    }

    public void deletePost (long id) {
        postRepository.deleteById(id);
    }
}
