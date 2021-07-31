package com.joaocpvaz.springboot2project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.joaocpvaz.springboot2project.domain.User;
import com.joaocpvaz.springboot2project.mapper.UserMapper;
import com.joaocpvaz.springboot2project.repository.UserRepository;
import com.joaocpvaz.springboot2project.request.UserPostRequestBody;
import com.joaocpvaz.springboot2project.request.UserPutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public Page<User> listAll(Pageable pageable){ return userRepository.findAll(pageable); }
	
	public List<User> listAllNonPageable() { return userRepository.findAll(); }
	
	public List<User> findByFirstName(String name) { return userRepository.findByFirstName(name); }
	
	public User findById(Long id){
		return userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Found"));
	}
	
	public User save(UserPostRequestBody userPostRequestBody) {
		return userRepository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
	}

	public void delete(long id) {
		userRepository.delete(findById(id));
	}

	public void replace(UserPutRequestBody userPutRequestBody) {
		User savedUser = findById(userPutRequestBody.getId());
		User user = UserMapper.INSTANCE.toUser(userPutRequestBody);
		user.setId(savedUser.getId());
		userRepository.save(user);
	}
	
}
