package com.example.spring_practice.mapper;


import com.example.spring_practice.dto.PostDTO;
import com.example.spring_practice.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDTOMapper {

    private PostDTOMapper(){}

    public static List<PostDTO> mapToPostDTOs(List<Post> posts) {
        return posts.stream()
                .map(post -> mapToPostDTO(post))
                .collect(Collectors.toList());
    }

    public static PostDTO mapToPostDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created(post.getCreated())
                .build();
    }
}
