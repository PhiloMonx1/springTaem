package com.week05.springtaem.controller;

import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.dto.PostRequestDto;
import com.week05.springtaem.model.dto.PostResponseDto;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
	private final PostService postService;
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public List<PostResponseDto> readAllPost(){
		return postService.readAllPost();
	}

	@GetMapping("post/{postId}")
	public Post readPost(@PathVariable Long postId){
		return postService.readPost(postId);
	}

	@PostMapping("/auth/post")
	public Post creatPost(@RequestBody PostRequestDto postRequestDto){
		return postService.creatPost(postRequestDto);
	}

	@PutMapping("/auth/post/{postId}")
	public Post updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto){
		return postService.updatePost(postId, postRequestDto);
	}

	@DeleteMapping("/auth/post/{postId}")
	public String deletePost(@PathVariable Long postId, @RequestBody UsernameDto usernameDto){
		return postService.deletePost(postId, usernameDto);
	}
}
