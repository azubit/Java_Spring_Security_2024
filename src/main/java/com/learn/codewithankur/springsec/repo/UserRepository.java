package com.learn.codewithankur.springsec.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.codewithankur.springsec.model.UserDTO;


@Repository
public interface UserRepository extends JpaRepository<UserDTO, String>{

	UserDTO getByUsername(String username);

	
}
