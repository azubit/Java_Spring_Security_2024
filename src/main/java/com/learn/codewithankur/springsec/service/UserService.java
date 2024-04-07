package com.learn.codewithankur.springsec.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.codewithankur.springsec.model.UserDTO;


@Service
public class UserService {

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	List<UserDTO> userList;

	public UserService() {

//		userList.add(new User("ankur","ankur1","ankur@gmail.com"));
//		userList.add(new User("swati","aaa","swati@gmail.com"));
//		userList.add(new User("kavya","bbb","kavya@gmail.com"));
		
	}

	public List<UserDTO> getAllUsers() {

		userList = customUserDetailsService.getAllUsers();
		return userList;
	}

	public UserDTO getUserByName(String username) {

		return userList.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}

	public String addUser(UserDTO user) {
		this.userList.add(user);
		return "success";
	}
}
