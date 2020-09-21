package com.web.jpa.j1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.jpa.j1.domain.User;

public interface UserRepositories extends JpaRepository<User, Long> {

	
}
