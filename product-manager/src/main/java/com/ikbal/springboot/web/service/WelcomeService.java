package com.ikbal.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	public String retrieveWelcomeMessage() {
		return "Good morning";
	}
}
