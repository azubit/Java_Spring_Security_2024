package com.learn.codewithankur.springsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.codewithankur.springsec.model.UserDTO;
import com.learn.codewithankur.springsec.service.UserService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<UserDTO> getUsers() {
		return this.userService.getAllUsers();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{userName}")
	public UserDTO getUserByName(@PathVariable String userName) {
		return this.userService.getUserByName(userName);
	}

	@PostMapping("/add")
	public String addUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}
}
