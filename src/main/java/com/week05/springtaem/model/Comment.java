package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.week05.springtaem.model.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@Column(nullable = false)
	private String content;

	@ManyToOne()
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@ManyToOne
	@JoinColumn(name = "POST_ID")
	@JsonBackReference
	private Post post;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Commit> commitList;

	@OneToMany(mappedBy = "comment", orphanRemoval = true)
	@JsonIgnore
	private List<Likes> likesList;

	private int commitCnt;
	private int likeCnt;

	public Comment(CommentRequestDto commentRequestDto, Post post, Users user) {
		this.userWriter = user.getUsername();
		this.content = commentRequestDto.getContent();
		this.post = post;
		this.users = user;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public void setCommitCnt(int commitCnt) {
		this.commitCnt = commitCnt;
	}

	public void updateComment(CommentRequestDto commentRequestDto){
		this.content = commentRequestDto.getContent();
	}

	public void addCommit(Commit commit) {
		this.commitList.add(commit);
	}
	public void removeCommit(Commit commit) {
		this.commitList.remove(commit);
	}

	public void addLikes(Likes likes){
		this.likesList.add(likes);
	}
	public void removeLikes(Likes likes){
		this.likesList.remove(likes);
	}
}