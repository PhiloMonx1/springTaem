package com.week05.springtaem.repository;

import com.week05.springtaem.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {
	Likes findByUsersAndPost(Users user, Post post);
	Likes findByUsersAndComment(Users user, Comment comment);
	Likes findByUsersAndCommit(Users user, Commit commit);
	List<Likes> findByUsersAndPostIsNotNull(Users user);
	List<Likes> findByUsersAndCommentIsNotNull(Users user);
	List<Likes> findByUsersAndCommitIsNotNull(Users user);
}
