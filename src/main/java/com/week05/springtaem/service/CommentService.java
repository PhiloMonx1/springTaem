package com.week05.springtaem.service;

import com.week05.springtaem.model.Comment;
import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.Users;
import com.week05.springtaem.model.dto.CommentRequestDto;
import com.week05.springtaem.model.dto.CommentResponseDto;
import com.week05.springtaem.repository.CommentRepository;
import com.week05.springtaem.repository.PostRepository;
import com.week05.springtaem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
	private final CommentRepository commentRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	public List<CommentResponseDto> readAllComment(Long postId) {
		List<Comment> commentList = commentRepository.findAllByPost_Id(postId);
		List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();

		for(Comment comment : commentList){
			commentResponseDtoList.add(new CommentResponseDto(comment));
		}

		return commentResponseDtoList;
	}

	public Comment readComment(Long commentId) {
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

		comment.setLikeCount(comment.getLikesList().size());
		comment.setCommitCount(comment.getCommitList().size());

		return comment;
	}

	public Comment creatComment(Long postId, CommentRequestDto commentRequestDto) {
		Users users = userRepository.findById(commentRequestDto.getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));

		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new NullPointerException("해당 아이디가 존재하지 않습니다."));

		Comment comment = new Comment(commentRequestDto, post, users);
		users.addComment(comment);
		post.addComment(comment);
		commentRepository.save(comment);
		return comment;
	}
}
