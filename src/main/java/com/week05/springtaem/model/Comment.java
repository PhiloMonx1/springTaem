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
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@Column(nullable = false)
	private String content;

	private int commitCount = 0;
	private int likes = 0;
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

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Likes> likesList;
}
