package com.in28minutes.springboot;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	public String retrieveWelcomeMessage() {
		return "Good morning";
	}
}
