package com.example.spring_practice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class PostDTO {
    private final long id;
    private final String title;
    private final String content;
    private final LocalDateTime created;

    public PostDTO (long id, String title, String content, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
