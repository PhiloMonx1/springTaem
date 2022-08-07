package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

	private Long id;
	private String userWriter;
	private String content;
	private int likeCnt = 0;
	private int commentCnt = 0;

	public CommentResponseDto(Comment comment) {
		this.id = comment.getId();
		this.userWriter = comment.getUserWriter();
		this.content = comment.getContent();
		this.likeCnt = comment.getLikesList().size();
		this.commentCnt = comment.getCommitList().size();
	}
}
