package com.joaocpvaz.springboot2project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaocpvaz.springboot2project.domain.User;
import com.joaocpvaz.springboot2project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> list() {
		return ResponseEntity.ok(userService.listAll());
	}
}
