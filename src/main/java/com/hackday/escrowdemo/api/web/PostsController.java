package com.hackday.escrowdemo.api.web;

import java.util.List;

import javax.validation.Valid;

import com.hackday.escrowdemo.api.domain.Posts;
import com.hackday.escrowdemo.api.domain.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/posts")
public class PostsController {

	@Autowired
	private PostsRepository postsRepository;

	@GetMapping()
	public ResponseEntity<List<Posts>> getAllPosts() {
		List<Posts> posts = postsRepository.findAll();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Posts> getPost(@PathVariable Long id) {
		Posts post = postsRepository.findById(id).get();
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Posts> createPost(@RequestBody @Valid Posts postRequestDto) {
		Posts post = postsRepository.save(postRequestDto);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Posts> updatePost(@PathVariable Long id,
	@RequestBody @Valid Posts postRequestDto) {
		Posts post = postsRepository.findById(id).get();
		Posts updatedPost = post.update(postRequestDto);
		return new ResponseEntity<>(updatedPost, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Posts> deletePost(@RequestBody @Valid Long id) {
		postsRepository.deleteById(id);;
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
