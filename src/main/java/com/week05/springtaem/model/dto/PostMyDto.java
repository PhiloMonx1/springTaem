package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Post;
import lombok.Getter;

@Getter
public class PostMyDto {
	private final String title;
	private final int likeCnt;
	private final int commentCnt;

	public PostMyDto(Post post) {
		this.title = post.getTitle();
		this.likeCnt = post.getLikeCnt();
		this.commentCnt = post.getCommentCnt();
	}
}
