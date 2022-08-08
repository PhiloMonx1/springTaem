package com.week05.springtaem.model.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MypageDto {
	private final List<PostMyDto> postMyDtoList = new ArrayList<>();
	private final List<CommentMyDto> commentMyDtoList = new ArrayList<>();
	private final List<CommitMyDto> commitMyDtoList = new ArrayList<>();

	public void addPostMyDtoList(PostMyDto postMyDto){
		this.postMyDtoList.add(postMyDto);
	}
	public void addCommentMyDtoList(CommentMyDto commentMyDto){
		this.commentMyDtoList.add(commentMyDto);
	}
	public void addCommitMyDtoList(CommitMyDto commitMyDto){
		this.commitMyDtoList.add(commitMyDto);
	}
}
