package com.example.spring_practice.service;

import com.example.spring_practice.model.Comment;
import com.example.spring_practice.repository.CommentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {
    private static final int PAGE_SIZE = 3;
    public CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments (int page, Sort.Direction sortDirection) {
        return commentRepository.findAllComments(PageRequest.of(page, PAGE_SIZE, Sort.by(sortDirection, "id")));
    }

    @Cacheable(cacheNames = "SingleComment", key = "#id")
    public Comment getSingleComment (long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    public Comment addComment (Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @CachePut(cacheNames = "SingleComment", key = "#result.id")
    public Comment editComment (Comment comment) {
        Comment commentEdited = commentRepository.findById(comment.getId()).orElseThrow();
        commentEdited.setContent(comment.getContent());
        return commentEdited;
    }

    @CacheEvict(cacheNames = "SingleComment")
    public void deleteComment (long id) {
        commentRepository.deleteById(id);
    }
}
