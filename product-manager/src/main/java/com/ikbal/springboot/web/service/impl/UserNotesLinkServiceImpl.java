package com.ikbal.springboot.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ikbal.springboot.web.model.Notes;
import com.ikbal.springboot.web.model.User;
import com.ikbal.springboot.web.service.NotesService;
import com.ikbal.springboot.web.service.UserNotesLinkService;
import com.ikbal.springboot.web.service.UserService;
import com.ikbal.springboot.web.util.ApplicationConstants;

@Service
public class UserNotesLinkServiceImpl implements UserNotesLinkService {

	@Autowired
	private UserService userService;

	@Autowired
	private NotesService notesService;

	@Override
	@Transactional
	public String addNoteToSpecificUser(User user, Notes note) throws Exception {
		// create new user
		User createdUser = userService.registerUser(user);
		Notes dbNote = new Notes();
		dbNote.setTitle(note.getTitle());
		dbNote.setMessage(note.getMessage());
		//int v = 1/0;
		// set created user to note
		dbNote.setUserDetails(createdUser);

		// persist new note
		notesService.addNote(dbNote);
		return ApplicationConstants.ADDED_NOTE_DESC;
	}

}
