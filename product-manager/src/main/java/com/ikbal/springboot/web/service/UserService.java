package com.ikbal.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikbal.springboot.web.model.User;
import com.ikbal.springboot.web.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;
	
	/*
	 Bean is method level annotation.
	 https://stackoverflow.com/questions/34172888/difference-between-bean-and-autowired
	 */
	@Bean
	 public BCryptPasswordEncoder passwordEncoders() {
	     return new BCryptPasswordEncoder();
	 } 

	public void save(User user) {
//		Optional<User> studentOptional = repo.findById(user.getId()); 
//		if (studentOptional.isPresent()) {
//			throw new IllegalStateException("user already exists");
//		}
		user.setPassword(passwordEncoders().encode(user.getPassword())); 
		
		repo.save(user); 
		System.out.println(user); 
	}
}
