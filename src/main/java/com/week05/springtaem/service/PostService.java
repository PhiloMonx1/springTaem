package com.week05.springtaem.service;

import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.Users;
import com.week05.springtaem.model.dto.CommentMyDto;
import com.week05.springtaem.model.dto.PostRequestDto;
import com.week05.springtaem.model.dto.PostResponseDto;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.repository.PostRepository;
import com.week05.springtaem.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;

	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	public List<PostResponseDto> readAllPost() {
		List<Post> postList = postRepository.findAllByOrderByModifiedAtDesc();
		List<PostResponseDto> postResponseDtoList = new ArrayList<>();

		for(Post post : postList){
			postResponseDtoList.add(new PostResponseDto(post));
		}

		return postResponseDtoList;
	}

	public Post readPost(Long postId) {
		return postRepository.findById(postId)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
	}

	public Post creatPost(PostRequestDto postRequestDto) {
		Users user = userRepository.findById(postRequestDto.getUsername())
				.orElseThrow(()-> new IllegalArgumentException("잘못된 사용자입니다. 다시 로그인 후 시도해주세요."));
		Post post = new Post(postRequestDto, user);

		user.addPost(post);
		postRepository.save(post);
		return post;
	}

	@Transactional
	public Post updatePost(Long postId, PostRequestDto postRequestDto) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

		post.updatePost(postRequestDto);
		return post;
	}

	public String deletePost(Long postId, UsernameDto usernameDto) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

		Users user = userRepository.findById(usernameDto.getUsername())
				.orElseThrow(()-> new IllegalArgumentException("잘못된 사용자입니다. 다시 로그인 후 시도해주세요."));

		user.removePost(post);

		postRepository.delete(post);
		return postId + "번 게시물 삭제완료.";
	}
}












