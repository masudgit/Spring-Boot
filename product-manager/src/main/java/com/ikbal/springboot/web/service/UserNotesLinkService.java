package com.ikbal.springboot.web.service;

import org.springframework.stereotype.Service;

import com.ikbal.springboot.web.model.Notes;
import com.ikbal.springboot.web.model.User;

/*
 * This interface is used to provide opration to link above created User with Note.
 */
		
@Service
public interface UserNotesLinkService {
    public String addNoteToSpecificUser(User user, Notes note) throws Exception;
}
