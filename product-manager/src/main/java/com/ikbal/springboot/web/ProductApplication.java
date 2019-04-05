package com.ikbal.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ikbal.springboot.web")
public class ProductApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ProductApplication.class, args);
		/*for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}*/
	}

}
