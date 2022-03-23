package com.ikbal.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

import com.ikbal.springboot.web.model.Notes;
import com.ikbal.springboot.web.model.User;
import com.ikbal.springboot.web.service.UserNotesLinkService;

@SpringBootApplication
@EnableJpaAuditing
@RestController
public class TransactionManagementApplication {

	@Autowired
	private UserNotesLinkService userNotesLinkService;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(TransactionManagementApplication.class, args);
		UserNotesLinkService userNotesLinkService = context.getBean(UserNotesLinkService.class);
		
		/* TEST DATA FOR TRANSACTION MANAGEMENT EXAMPLE*/
		// create new user
		User user = new User();
		user.setUsername("alham");
		user.setPassword("12345");
		//user.setId(1l); 
		
		//create new note
		Notes note = new Notes();
		note.setTitle("Test note");
		note.setMessage("Test Message");
		
		//link above new user with above note
		userNotesLinkService.addNoteToSpecificUser(user, note); 
	}
}
