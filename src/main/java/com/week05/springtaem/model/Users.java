package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Getter
@NoArgsConstructor
@Entity
public class Users extends Timestamped{

	@Id
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	@JsonIgnore
	private String password;

	@OneToMany(cascade = CascadeType.REFRESH)
	@JsonManagedReference
	private List<Post> postList;

	@OneToMany(mappedBy = "users")
	@JsonManagedReference
	private List<Comment> commentList;

	@OneToMany(mappedBy = "users")
	@JsonManagedReference
	private List<Commit> commitList;

	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private List<Likes> likesList;

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void addPost(Post post){
		this.postList.add(post);
	}
	public void removePost (Post post){
		this.postList.remove(post);
	}

	public void addComment(Comment comment){
		this.commentList.add(comment);
	}
	public void removeComment (Comment comment){
		this.commentList.remove(comment);
	}

	public void addCommit(Commit commit){
		this.commitList.add(commit);
	}
	public void removeCommit (Commit commit){
		this.commitList.remove(commit);
	}

	public void addLikes(Likes likes){
		this.likesList.add(likes);
	}
	public void removeLikes(Likes likes){
		this.likesList.remove(likes);
	}
}

