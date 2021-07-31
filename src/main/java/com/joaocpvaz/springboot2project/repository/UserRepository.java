package com.joaocpvaz.springboot2project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocpvaz.springboot2project.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
