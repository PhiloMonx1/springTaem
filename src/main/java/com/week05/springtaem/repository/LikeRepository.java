package com.week05.springtaem.repository;

import com.week05.springtaem.model.Likes;
import com.week05.springtaem.model.Post;
import com.week05.springtaem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {
	Likes findByUsersAndPost(Users users, Post post);
}
