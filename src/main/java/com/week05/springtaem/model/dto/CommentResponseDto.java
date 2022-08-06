package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Commit;

import java.util.List;

public class CommentResponseDto {

	private Long id;
	private String userWriter;
	private String content;
	private int like = 0;
	private List<Commit> commitList;
}
