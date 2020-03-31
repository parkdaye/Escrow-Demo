package com.hackday.escrowdemo.api.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // @After
    // public void cleanup() {
    //     //postsRepository.deleteAll();
    // }

    @Test
    public void SaveAndGet() {
        //given
        postsRepository.save(Posts.builder()
                .title("test")
                .content("테스트입니다")
                .author("daye")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("test"));
        assertThat(posts.getContent(), is("테스트입니다"));
    }
}