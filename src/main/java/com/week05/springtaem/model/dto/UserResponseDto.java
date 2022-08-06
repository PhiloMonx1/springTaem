package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;
import com.week05.springtaem.model.Commit;
import com.week05.springtaem.model.Post;

import java.util.List;


public class UserResponseDto {
	private String username;

	private List<Post> postList;

	private List<Comment> commentList;

	private List<Commit> commitList;
}
