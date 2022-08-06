package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userWriter;

	@ManyToOne
	@JoinColumn(name = "USERNAME")
	@JsonBackReference
	private Users users;

	@ManyToOne
	@JoinColumn(name = "POST_ID")
	@JsonBackReference
	private Post post;

	@ManyToOne
	@JoinColumn(name = "COMMENT_ID")
	@JsonBackReference
	private Comment comment;

	@ManyToOne
	@JoinColumn(name = "COMMIT_ID")
	@JsonBackReference
	private Commit commit;

}
