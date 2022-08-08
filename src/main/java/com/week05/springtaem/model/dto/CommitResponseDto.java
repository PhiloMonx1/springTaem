package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Commit;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommitResponseDto {
	private final LocalDateTime createdAt;
	private final LocalDateTime modifiedAt;
	private final Long id;
	private final String userWriter;
	private final String content;
	private final int likeCnt;

	public CommitResponseDto(Commit commit) {
		this.createdAt = commit.getCreatedAt();
		this.modifiedAt = commit.getModifiedAt();
		this.id = commit.getId();
		this.userWriter = commit.getUserWriter();
		this.content = commit.getContent();
		this.likeCnt = commit.getLikesList().size();
	}
}
