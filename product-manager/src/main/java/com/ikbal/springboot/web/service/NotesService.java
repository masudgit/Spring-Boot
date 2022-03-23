package com.ikbal.springboot.web.service;

import org.springframework.stereotype.Service;

import com.ikbal.springboot.web.model.Notes;

/*
 * This interface is used to provide operation to add new Note.
 */

@Service
public interface NotesService {
	public String addNote(Notes note) throws Exception;
}
