package com.ikbal.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ikbal.springboot.web.model.MyUserDetails;
import com.ikbal.springboot.web.model.User;
import com.ikbal.springboot.web.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	/*Working with Spring Data Repositories
	The goal of Spring Data repository abstraction is to significantly reduce the amount of boilerplate
	 code required to implement data access layers for various persistence stores.*/
	
	@Autowired
	private UserRepository userReporsitory;  
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userReporsitory.getUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not find used");
		}
		
		return new MyUserDetails(user) ; 
	}

	
}
