package com.example.spring_practice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class CommentDTO {

    private final long id;
    private final long postId;
    private final String content;
    private final LocalDateTime created;

    public CommentDTO (long id, long postId, String content, LocalDateTime created) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.created = created;
    }

    public long getId () {
        return id;
    }

    public long getPostId () {
        return postId;
    }

    public String getContent () {
        return content;
    }

    public LocalDateTime getCreated () {
        return created;
    }

}
