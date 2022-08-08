package com.week05.springtaem.repository;

import com.week05.springtaem.model.Comment;
import com.week05.springtaem.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByPost_Id(Long postId);
}
