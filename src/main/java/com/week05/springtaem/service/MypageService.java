package com.week05.springtaem.service;

import com.week05.springtaem.model.*;
import com.week05.springtaem.model.dto.*;
import com.week05.springtaem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MypageService {
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;
	private final CommitRepository commitRepository;
	private final LikeRepository likeRepository;
	@Autowired
	public MypageService(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository, CommitRepository commitRepository, LikeRepository likeRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
		this.commitRepository = commitRepository;
		this.likeRepository = likeRepository;
	}

	public MypageDto readMypage(String userId) {
		MypageDto mypageDto = new MypageDto();
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
		List<Post> postList = postRepository.findAllByUsers(user);
		List<Comment> commentList = commentRepository.findAllByUsers(user);
		List<Commit> commitList = commitRepository.findAllByUsers(user);
		List<Likes> postIsNotNullList = likeRepository.findByUsersAndPostIsNotNull(user);
		List<Likes> commentIsNotNullList = likeRepository.findByUsersAndCommentIsNotNull(user);
		List<Likes> commitIsNotNullList = likeRepository.findByUsersAndCommitIsNotNull(user);

		for(Post post : postList){
			mypageDto.addPostMyDtoList(new PostMyDto(post));
		}
		for(Comment comment : commentList){
			mypageDto.addCommentMyDtoList(new CommentMyDto(comment));
		}
		for(Commit commit : commitList){
			mypageDto.addCommitMyDtoList(new CommitMyDto(commit));
		}
		for (Likes likePost : postIsNotNullList) {
			mypageDto.addPostMyDtoList(new PostMyLikeDto(likePost.getPost()));
		}
		for (Likes likesComment : commentIsNotNullList) {
			mypageDto.addCommentMyDtoList(new CommentMyLikeDto(likesComment.getComment()));
		}
		for (Likes likesCommit : commitIsNotNullList) {
			mypageDto.addCommitMyDtoList(new CommitMyLikeDto(likesCommit.getCommit()));
		}

		return mypageDto;
	}
}
























