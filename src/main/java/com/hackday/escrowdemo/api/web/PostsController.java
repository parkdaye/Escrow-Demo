package com.hackday.escrowdemo.api.web;

import java.util.List;

import com.hackday.escrowdemo.api.domain.Posts;
import com.hackday.escrowdemo.api.domain.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

	@Autowired
	private PostsRepository postsRepository;
	
	@GetMapping("/*")
	public String index() {
		return "index";
	}

	@GetMapping("/posts")
	public ResponseEntity<List<Posts>> getAllPosts(){
		List<Posts> post = postsRepository.findAll();
        return new ResponseEntity<>(post, HttpStatus.OK);
	}

}
