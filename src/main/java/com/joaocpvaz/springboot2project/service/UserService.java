package com.joaocpvaz.springboot2project.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.joaocpvaz.springboot2project.domain.User;
import com.joaocpvaz.springboot2project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id){
		return userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Found"));
	}

	public User save(User user) {
		userRepository.save(user);
		return user;
	}

	public void delete(long id) {
		userRepository.delete(findById(id));
	}

	public void replace(User user) {
		delete(user.getId());
		userRepository.save(user);
	}
	
	
}
