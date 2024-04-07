package com.learn.codewithankur.springsec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.codewithankur.springsec.controller.UserController;
import com.learn.codewithankur.springsec.model.UserDTO;
import com.learn.codewithankur.springsec.repo.UserRepository;

@SpringBootApplication
public class SpringSecuritydemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserController userController;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		UserDTO user1 = new UserDTO("ankur", bCryptPasswordEncoder().encode("abc"), "an@gmail.com","ROLE_ADMIN");
		UserDTO user2 = new UserDTO("swati", bCryptPasswordEncoder().encode("abc"), "sw@gmail.com","ROLE_USER");
		
		List<UserDTO> userList = new ArrayList<UserDTO>();
		userList.add(user1);
		userList.add(user2);
		userRepository.saveAll(userList);		
	
		userController.getUsers();
	}
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}	
}
