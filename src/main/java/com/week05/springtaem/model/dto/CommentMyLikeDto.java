package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;
import lombok.Getter;

@Getter
public class CommentMyLikeDto {
	private final String content;
	private final int likeCnt;
	private final int commentCnt;

	public CommentMyLikeDto(Comment comment) {
		this.content = comment.getContent();
		this.likeCnt = comment.getLikesList().size();
		this.commentCnt = comment.getCommitList().size();
	}
}
