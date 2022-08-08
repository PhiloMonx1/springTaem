package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.week05.springtaem.model.dto.CommitRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Commit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@Column(nullable = false)
	private String content;

	private int likes = 0;

	@ManyToOne
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@ManyToOne
	@JoinColumn(name = "COMMENT_ID")
	@JsonBackReference
	private Comment comment;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Likes> likesList;

	public Commit(CommitRequestDto commitRequestDto, Comment comment, Users users) {
		this.userWriter = users.getUsername();
		this.content = commitRequestDto.getContent();
		this.comment = comment;
		this.users = users;
	}

	public void updateCommit(CommitRequestDto commitRequestDto){
		this.content = commitRequestDto.getContent();
	}
}
