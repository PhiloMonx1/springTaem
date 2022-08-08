package com.week05.springtaem.model.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MypageDto {
	private final List<PostMyDto> postMyDtoList = new ArrayList<>();
	private final List<CommentMyDto> commentMyDtoList = new ArrayList<>();
	private final List<CommitMyDto> commitMyDtoList = new ArrayList<>();
	private final List<PostMyLikeDto> postMyLikeDtoList = new ArrayList<>();
	private final List<CommentMyLikeDto> commentMyLikeDtoArrayList = new ArrayList<>();
	private final List<CommitMyLikeDto> commitMyLikeDtoArrayList = new ArrayList<>();

	public void addPostMyDtoList(PostMyDto postMyDto){
		this.postMyDtoList.add(postMyDto);
	}
	public void addCommentMyDtoList(CommentMyDto commentMyDto){
		this.commentMyDtoList.add(commentMyDto);
	}
	public void addCommitMyDtoList(CommitMyDto commitMyDto){
		this.commitMyDtoList.add(commitMyDto);
	}
	public void addPostMyDtoList(PostMyLikeDto postMyLikeDto){
		this.postMyLikeDtoList.add(postMyLikeDto);
	}
	public void addCommentMyDtoList(CommentMyLikeDto commentMyLikeDto){
		this.commentMyLikeDtoArrayList.add(commentMyLikeDto);
	}
	public void addCommitMyDtoList(CommitMyLikeDto commitMyDto){
		this.commitMyLikeDtoArrayList.add(commitMyDto);
	}
}
