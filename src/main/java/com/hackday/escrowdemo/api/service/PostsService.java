package com.hackday.escrowdemo.api.service;

import com.hackday.escrowdemo.api.domain.Posts;
import com.hackday.escrowdemo.api.domain.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Transactional
    public void savePost(Posts post) {
        postsRepository.save(post);
    }
}