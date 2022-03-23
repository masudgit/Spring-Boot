package com.ikbal.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ikbal.springboot.web.model.User;
import com.ikbal.springboot.web.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	UserService service;

	@RequestMapping("/newUser")
	public String showNewUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	} 
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.registerUser(user);   

		return "redirect:/";
	}
	
}
