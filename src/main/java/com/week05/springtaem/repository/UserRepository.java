package com.week05.springtaem.repository;

import com.week05.springtaem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
