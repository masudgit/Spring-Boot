package com.ikbal.in28minutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class In28minutesApplication {

	public static void main(String[] args) {
		ApplicationContext  applicationContext =  SpringApplication.run(In28minutesApplication.class, args);
		for(String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
