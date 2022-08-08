package com.week05.springtaem.controller;

import com.week05.springtaem.model.Comment;
import com.week05.springtaem.model.dto.CommentRequestDto;
import com.week05.springtaem.model.dto.CommentResponseDto;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
	private final CommentService commentService;
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/comments/{postId}")
	public List<CommentResponseDto> readAllComment(@PathVariable Long postId) {
		return commentService.readAllComment(postId);
	}

	@GetMapping("/comment/{commentId}")
	public Comment readComment(@PathVariable Long commentId) {
		return commentService.readComment(commentId);
	}

	@PostMapping("/auth/comment/{postId}")
	public Comment creatComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto) {
		return commentService.creatComment(postId, commentRequestDto);
	}

	@PatchMapping("/auth/comment/{commentId}")
	public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
		return commentService.updateComment(commentId, commentRequestDto);
	}

	@DeleteMapping("/auth/comment/{commentId}")
	public String deleteComment(@PathVariable Long commentId, @RequestBody UsernameDto usernameDto) {
		return commentService.deleteComment(commentId, usernameDto);
	}


}










