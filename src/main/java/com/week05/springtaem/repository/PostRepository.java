package com.week05.springtaem.repository;

import com.week05.springtaem.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
