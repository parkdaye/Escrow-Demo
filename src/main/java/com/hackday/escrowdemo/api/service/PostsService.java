package com.hackday.escrowdemo.api.service;

import com.hackday.escrowdemo.api.domain.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO : 트랜잭션 처리, 에러 처리
 */
@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;
}