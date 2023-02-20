package com.example.spring_practice.service;

import com.example.spring_practice.model.Comment;
import com.example.spring_practice.model.Post;
import com.example.spring_practice.repository.CommentRepository;
import com.example.spring_practice.repository.PostRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private static final int PAGE_SIZE = 3;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    @Cacheable(cacheNames = "SinglePost", key = "#id")
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
    @CachePut(cacheNames = "SinglePost", key = "#result.id")
    public Post editPost (Post post) {
        Post postEdited = postRepository.findById(post.getId()).orElseThrow();
        postEdited.setTitle(post.getTitle());
        postEdited.setContent(post.getContent());
        return postEdited;
    }

    @CacheEvict(cacheNames = "SinglePost")
    public void deletePost (long id) {
        postRepository.deleteById(id);
    }

    @Cacheable(cacheNames = "PostsWithComments")
    public List<Post> getPostsWithComments (int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));

        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));

        return allPosts;
    }

    private List<Comment> extractComments (List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
}
