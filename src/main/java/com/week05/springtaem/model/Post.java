package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.week05.springtaem.model.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
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

	private int likeCnt = 0;
	private int commentCnt = 0;

	@ManyToOne()
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Comment> commentList;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Likes> likesList;

	public Post(PostRequestDto postRequestDto, Users users) {
		this.userWriter = users.getUsername();
		this.title = postRequestDto.getTitle();
		this.content = postRequestDto.getContent();
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
}
