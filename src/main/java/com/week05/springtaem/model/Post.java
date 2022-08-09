package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.week05.springtaem.model.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "ARTICLE")
public class Post extends Timestamped{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@ManyToOne()
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Comment> commentList;


	@OneToMany(mappedBy = "post", orphanRemoval = true)
	@JsonIgnore
	private List<Likes> likesList;

	private int likeCnt;
	private int commentCnt;

	public Post(PostRequestDto postRequestDto, Users user) {
		this.userWriter = user.getUsername();
		this.title = postRequestDto.getTitle();
		this.content = postRequestDto.getContent();
		this.users = user;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public void setCommentCount(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public void updatePost(PostRequestDto postRequestDto){
		this.title = postRequestDto.getTitle();
		this.content = postRequestDto.getContent();
	}

	public void addComment(Comment comment) {
		this.commentList.add(comment);
	}
	public void removeComment(Comment comment) {
		this.commentList.remove(comment);
	}

	public void addLikes(Likes likes){
		this.likesList.add(likes);
	}
	public void removeLikes(Likes likes){
		this.likesList.remove(likes);
	}
}
