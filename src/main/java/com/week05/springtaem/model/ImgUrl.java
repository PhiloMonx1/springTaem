package com.week05.springtaem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ImgUrl {
	@Id
	@Column(nullable = false, unique = true)
	private String url;

	@ManyToOne
	@JoinColumn(name = "POST_ID")
	@JsonIgnore
	private Post post;

	public ImgUrl(String url, Post post) {
		this.url = url;
		this.post = post;
	}
}
