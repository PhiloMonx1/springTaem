package com.week05.springtaem.repository;

import com.week05.springtaem.model.Commit;
import com.week05.springtaem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommitRepository extends JpaRepository<Commit, Long> {
	List<Commit> findAllByComment_Id(Long commentId);
	List<Commit> findAllByUsers(Users user);
}
