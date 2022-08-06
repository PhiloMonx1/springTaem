package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;

import java.util.List;

public class PostResponseDto {

	private Long id;
	private String userWriter;
	private String title;
	private String content;
	private int like = 0;
	private List<Comment> commentList;
}
