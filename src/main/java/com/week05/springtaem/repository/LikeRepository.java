package com.week05.springtaem.repository;

import com.week05.springtaem.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {
}
