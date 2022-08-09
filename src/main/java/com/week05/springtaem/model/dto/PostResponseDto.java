package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private Long id;
	private String username;
	private String title;
	private int likeCnt;
	private int commentCnt;

	public PostResponseDto(Post post) {
		this.createdAt = post.getCreatedAt();
		this.modifiedAt = post.getModifiedAt();
		this.id = post.getId();
		this.username = post.getUserWriter();
		this.title = post.getTitle();
		this.likeCnt = post.getLikesList().size();
		this.commentCnt = post.getCommentList().size();
	}
}
