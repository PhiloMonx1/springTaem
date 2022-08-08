package com.week05.springtaem.model.dto;

import com.week05.springtaem.model.Comment;
import com.week05.springtaem.model.Commit;
import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.Users;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserResponseDto {
	private final LocalDateTime createdAt;
	private final LocalDateTime modifiedAt;
	private final String username;
	private final List<Post> postList;
	private final List<Comment> commentList;
	private final List<Commit> commitList;

	public UserResponseDto(Users user) {
		this.createdAt = user.getCreatedAt();
		this.modifiedAt = user.getModifiedAt();
		this.username = user.getUsername();
		this.postList = user.getPostList();
		this.commentList = user.getCommentList();
		this.commitList = user.getCommitList();
	}
}
