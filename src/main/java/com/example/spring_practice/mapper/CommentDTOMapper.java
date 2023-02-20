package com.example.spring_practice.mapper;


import com.example.spring_practice.dto.CommentDTO;
import com.example.spring_practice.model.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentDTOMapper {

    private CommentDTOMapper() {}
    public static List<CommentDTO> mapToCommentDTOs(List<Comment> comments) {
        return comments.stream()
                .map(comment -> mapToCommentDTO(comment))
                .collect(Collectors.toList());
    }
    public static CommentDTO mapToCommentDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .created(comment.getCreated())
                .build();
    }
}
