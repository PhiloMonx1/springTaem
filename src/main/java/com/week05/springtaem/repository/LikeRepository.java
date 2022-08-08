package com.week05.springtaem.repository;

import com.week05.springtaem.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {
	Likes findByUsersAndPost(Users users, Post post);
	Likes findByUsersAndComment(Users users, Comment comment);
	Likes findByUsersAndCommit(Users users, Commit commit);
}
