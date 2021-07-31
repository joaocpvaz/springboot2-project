package com.joaocpvaz.springboot2project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocpvaz.springboot2project.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByFirstName(String name);
}
