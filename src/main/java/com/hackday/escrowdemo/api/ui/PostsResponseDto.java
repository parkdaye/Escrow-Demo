package com.hackday.escrowdemo.api.ui;

import com.hackday.escrowdemo.api.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostsResponseDto {

    private long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.author = posts.getAuthor();
        this.title = posts.getTitle();
        this.content = posts.getContent();
    }

}