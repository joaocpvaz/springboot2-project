package com.joaocpvaz.springboot2project.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaocpvaz.springboot2project.domain.User;
import com.joaocpvaz.springboot2project.request.UserPostRequestBody;
import com.joaocpvaz.springboot2project.request.UserPutRequestBody;
import com.joaocpvaz.springboot2project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<Page<User>> list(Pageable pageable) {
		return ResponseEntity.ok(userService.listAll(pageable));
	}
	
	@GetMapping (path = "/all")
	public ResponseEntity<List<User>> listAll() {
		return ResponseEntity.ok(userService.listAllNonPageable());
	}
	
	@GetMapping (path = "/find")
	public ResponseEntity<List<User>> findByFirstName(@RequestParam String name) {
		return ResponseEntity.ok(userService.findByFirstName(name));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody UserPostRequestBody userPostRequestBody) {
		return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody UserPutRequestBody userPutRequestBody){
		userService.replace(userPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
