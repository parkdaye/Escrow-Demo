package com.hackday.escrowdemo.api.ui;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  TODO : ui layer와 domain 구분하기
 */
@Getter @Setter
@NoArgsConstructor
public class PostsResponseDto {

    private long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsResponseDto(PostsResponseDto posts) {
        this.id = posts.getId();
        this.author = posts.getAuthor();
        this.title = posts.getTitle();
        this.content = posts.getContent();
    }

}