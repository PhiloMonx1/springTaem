package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Commit;
import lombok.Getter;

@Getter
public class CommitResponseDto {
	private Long id;
	private String userWriter;
	private String content;
	private int likeCnt = 0;

	public CommitResponseDto(Commit commit) {
		this.id = commit.getId();
		this.userWriter = commit.getUserWriter();
		this.content = commit.getContent();
		this.likeCnt = commit.getLikesList().size();
	}
}
