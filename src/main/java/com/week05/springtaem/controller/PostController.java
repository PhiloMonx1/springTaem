package com.week05.springtaem.controller;

import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.dto.PostRequestDto;
import com.week05.springtaem.model.dto.PostResponseDto;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.s3.S3Uploader;
import com.week05.springtaem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
	private final PostService postService;
	private final S3Uploader s3Uploader;

	@Autowired

	public PostController(PostService postService, S3Uploader s3Uploader) {
		this.postService = postService;
		this.s3Uploader = s3Uploader;
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

	@PostMapping("/auth/post/image")
	public String upload( MultipartFile multipartFile, String dirName) throws IOException {
		return s3Uploader.upload(multipartFile, "post") + " 등록 완료.";
	}

	@PatchMapping("/auth/post/{postId}")
	public Post updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto){
		return postService.updatePost(postId, postRequestDto);
	}

	@DeleteMapping("/auth/post/{postId}")
	public String deletePost(@PathVariable Long postId, @RequestBody UsernameDto usernameDto){
		return postService.deletePost(postId, usernameDto);
	}
}
