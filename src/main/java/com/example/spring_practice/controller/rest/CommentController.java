package com.example.spring_practice.controller.rest;

import com.example.spring_practice.dto.CommentDTO;
import com.example.spring_practice.mapper.CommentDTOMapper;
import com.example.spring_practice.model.Comment;
import com.example.spring_practice.service.CommentService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<CommentDTO> getComments(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return CommentDTOMapper.mapToCommentDTOs(commentService.getComments(pageNumber, sortDirection));
    }

    @GetMapping("/comments/{id}")
    public Comment getSingleComment(@PathVariable long id) {
        return commentService.getSingleComment(id);
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping("/comments")
    public Comment editComment(@RequestBody Comment comment) {
        return commentService.editComment(comment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
    }
}
