package com.week05.springtaem.service;

import com.week05.springtaem.model.*;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LikeService {
	private final LikeRepository likeRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;
	private final CommitRepository commitRepository;
	@Autowired
	public LikeService(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository, CommitRepository commitRepository) {
		this.likeRepository = likeRepository;
		this.userRepository = userRepository;
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
		this.commitRepository = commitRepository;
	}


	@Transactional
	public String postLike(Long postId, UsernameDto usernameDto) {
		Users user = userRepository.findById(usernameDto.getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new NullPointerException("해당 게시물이 존재하지 않습니다."));


		if(likeRepository.findByUsersAndPost(user, post) == null){
			Likes like = new Likes(user, post);
			user.addLikes(like);
			post.addLikes(like);
			return post.getId() + "번 게시물 좋아요";
		}else  {
			Likes like = likeRepository.findByUsersAndPost(user, post);
			user.removeLikes(like);
			post.removeLikes(like);
			return post.getId() + "번 게시물 좋아요 취소";
		}
	}


	@Transactional
	public String commentLike(Long commentId, UsernameDto usernameDto) {
		Users user = userRepository.findById(usernameDto.getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(()-> new NullPointerException("해당 댓글이 존재하지 않습니다."));


		if(likeRepository.findByUsersAndComment(user, comment) == null){
			Likes like = new Likes(user, comment);
			user.addLikes(like);
			comment.addLikes(like);
			return comment.getId() + "번 댓글 좋아요";
		}else  {
			Likes like = likeRepository.findByUsersAndComment(user, comment);
			user.removeLikes(like);
			comment.removeLikes(like);
			return comment.getId() + "번 댓글 좋아요 취소";
		}
	}
	@Transactional
	public String commitLike(Long commitId, UsernameDto usernameDto) {
		Users user = userRepository.findById(usernameDto.getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
		Commit commit = commitRepository.findById(commitId)
				.orElseThrow(()-> new NullPointerException("해당 대댓글이 존재하지 않습니다."));


		if(likeRepository.findByUsersAndCommit(user, commit) == null){
			Likes like = new Likes(user, commit);
			user.addLikes(like);
			commit.addLikes(like);
			return commit.getId() + "번 대댓글 좋아요";
		}else  {
			Likes like = likeRepository.findByUsersAndCommit(user, commit);
			user.removeLikes(like);
			commit.removeLikes(like);
			return commit.getId() + "번 게시물 좋아요 취소";
		}
	}
}



















