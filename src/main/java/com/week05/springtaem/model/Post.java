package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	private int commentCount = 0;
	private int like = 0;

	@ManyToOne()
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Comment> commentList;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Like> likeList;
}