package com.week05.springtaem.service;

import com.week05.springtaem.model.Likes;
import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.Users;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



	public String postLike(Long postId, UsernameDto usernameDto) {
		Users user = userRepository.findById(usernameDto.getUsername())
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
		Post post = postRepository.findById(postId)
				.orElseThrow(()-> new NullPointerException("해당 게시물이 존재하지 않습니다."));


		if(likeRepository.findByUsersAndPost(user, post) == null){
			Likes like = new Likes(user, post);
			user.addLikes(like);
			post.addLikes(like);
			likeRepository.save(like);
			return post.getId() + "번 게시물 좋아요";
		}else  {
			Likes like = likeRepository.findByUsersAndPost(user, post);
			user.removeLikes(like);
			post.removeLikes(like);
			likeRepository.delete(like);
			return post.getId() + "번 게시물 좋아요 취소";
		}
	}


}



















