package com.week05.springtaem.model.dto;

import lombok.Getter;

@Getter
public class CommitResponseDto {

	private Long id;
	private String userWriter;
	private String content;
	private int like = 0;
}
