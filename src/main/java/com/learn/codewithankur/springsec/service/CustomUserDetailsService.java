package com.learn.codewithankur.springsec.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.learn.codewithankur.springsec.model.CustomUserDetails;
import com.learn.codewithankur.springsec.model.UserDTO;
import com.learn.codewithankur.springsec.repo.UserRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO user = repository.getByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No user");
		}
		
	 return new CustomUserDetails(user);
	}

	public List<UserDTO> getAllUsers(){
		
		return repository.findAll();
	}
}
