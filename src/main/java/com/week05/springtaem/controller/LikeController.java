package com.week05.springtaem.controller;

import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LikeController {
	private final LikeService likeService;
	@Autowired
	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

	@PostMapping("/auth/post/like/{postId}")
	private String postLike(@PathVariable Long postId, @RequestBody UsernameDto usernameDto){
		return likeService.postLike(postId, usernameDto);
	}

}
