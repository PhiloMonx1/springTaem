package com.week05.springtaem.service;

import com.week05.springtaem.model.dto.MypageDto;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public MypageDto readMypage(Long userId, UsernameDto usernameDto) {
		MypageDto mypageDto = new MypageDto();





		return mypageDto;
	}
}
























