package com.joaocpvaz.springboot2project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.joaocpvaz.springboot2project.domain.User;

@Service
public class UserService {
	
	private static List<User> users;
	
	static {
		users = new ArrayList<>(List.of(new User(1L,"Joao", "Chagas", "joao@gmail.com")));
	}
	
	public List<User> listAll(){
		return users;
	}
	
	public User findById(Long id){
		return users.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Found"));
	}

	public User save(User user) {
		user.setId(ThreadLocalRandom.current().nextLong(2,10000));
		users.add(user);
		return user;
	}

	public void delete(long id) {
		users.remove(findById(id));
	}

	public void replace(User user) {
		delete(user.getId());
		users.add(user);
	}
	
	
}
