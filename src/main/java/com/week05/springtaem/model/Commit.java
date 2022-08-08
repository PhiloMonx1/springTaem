package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.week05.springtaem.model.dto.CommitRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Commit extends Timestamped{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@Column(nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@ManyToOne
	@JoinColumn(name = "COMMENT_ID")
	@JsonBackReference
	private Comment comment;

	@OneToMany(mappedBy = "commit", orphanRemoval = true)
	@JsonIgnore
	private List<Likes> likesList;

	private int likeCnt;


	public Commit(CommitRequestDto commitRequestDto, Comment comment, Users user) {
		this.userWriter = user.getUsername();
		this.content = commitRequestDto.getContent();
		this.comment = comment;
		this.users = user;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public void updateCommit(CommitRequestDto commitRequestDto){
		this.content = commitRequestDto.getContent();
	}

	public void addLikes(Likes likes){
		this.likesList.add(likes);
	}
	public void removeLikes(Likes likes){
		this.likesList.remove(likes);
	}
}
