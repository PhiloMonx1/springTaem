package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "POST_ID")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "COMMENT_ID")
	private Comment comment;

	@ManyToOne
	@JoinColumn(name = "COMMIT_ID")
	private Commit commit;

	public void setUsers(Users users) {this.users = users;}
	public void setPost(Post post) {this.post = post;}
	public void setComment(Comment comment) {this.comment = comment;}
	public void setCommit(Commit commit) {this.commit = commit;}

	public Likes(Users users, Post post) {
		this.users = users;
		this.post = post;
	}
	public Likes(Users users, Comment comment) {
		this.users = users;
		this.comment = comment;
	}
	public Likes(Users users, Commit commit) {
		this.users = users;
		this.commit = commit;
	}
}
