package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;
import lombok.Getter;

@Getter
public class CommentMyDto {
	private final String content;
	private final int likeCnt;
	private  int commentCnt;

	public CommentMyDto(Comment comment) {
		this.content = comment.getContent();
		this.likeCnt = comment.getLikesList().size();
		this.commentCnt = comment.getCommitList().size();
	}
}
