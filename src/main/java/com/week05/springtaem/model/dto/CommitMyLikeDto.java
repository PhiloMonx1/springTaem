package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Commit;
import lombok.Getter;

@Getter
public class CommitMyLikeDto {
	private final String content;
	private final int likeCnt;

	public CommitMyLikeDto(Commit commit) {
		this.content = commit.getContent();
		this.likeCnt = commit.getLikesList().size();
	}
}
