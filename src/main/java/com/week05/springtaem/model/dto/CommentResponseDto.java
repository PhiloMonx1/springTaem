package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
	private final LocalDateTime createdAt;
	private final LocalDateTime modifiedAt;
	private final Long id;
	private final String userWriter;
	private final String content;
	private final int likeCnt;
	private final int commentCnt;

	public CommentResponseDto(Comment comment) {
		this.createdAt = comment.getCreatedAt();
		this.modifiedAt = comment.getModifiedAt();
		this.id = comment.getId();
		this.userWriter = comment.getUserWriter();
		this.content = comment.getContent();
		this.likeCnt = comment.getLikesList().size();
		this.commentCnt = comment.getCommitList().size();
	}
}
