package com.ikbal.springboot.web.service;

import org.springframework.stereotype.Service;

import com.ikbal.springboot.web.model.User;

@Service
public interface UserService {
	public User registerUser(User user);
}
