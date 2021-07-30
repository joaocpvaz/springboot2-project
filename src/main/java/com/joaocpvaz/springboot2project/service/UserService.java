package com.joaocpvaz.springboot2project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.joaocpvaz.springboot2project.domain.User;

@Service
public class UserService {
	
	private static List<User> users;
	
	static {
		users = new ArrayList<>(List.of(new User("Joao", "Chagas", "joao@gmail.com")));
	}
	
	public List<User> listAll(){
		return users;
	}
}
