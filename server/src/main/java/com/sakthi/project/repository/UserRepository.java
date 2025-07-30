package com.sakthi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sakthi.project.model.User;

@Service
public interface UserRepository extends JpaRepository<User,Long> {

	
}
