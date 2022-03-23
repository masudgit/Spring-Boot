package com.ikbal.springboot.web.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikbal.springboot.web.model.Notes;
import com.ikbal.springboot.web.repository.NotesRepository;
import com.ikbal.springboot.web.service.NotesService;
import com.ikbal.springboot.web.util.ApplicationConstants;

@Service
public class NotesServiceImpl implements NotesService {
	private static final Logger log = LogManager.getLogger(NotesServiceImpl.class);

	@Autowired
	private NotesRepository noteRepository;

	@Override
	public String addNote(Notes note) {
		log.info("Inside add note service");
		noteRepository.save(note);
		log.info("Successfully added new Note.");
		return ApplicationConstants.ADDED_NOTE_DESC;
	}

}
