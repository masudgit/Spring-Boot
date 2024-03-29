package com.ikbal.springboot.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ikbal.springboot.web.util.ApplicationConstants;

@Entity
@Table(name = "Notes")
public class Notes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "note_Id")
	private Long noteId;

	/*
	 * In case of we need to maintain many notes to one User relation through User
	 * Entity
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userDetails;

	@NotEmpty(message = ApplicationConstants.VALIDATION_TITLE_EMPTY)
	@NotBlank(message = ApplicationConstants.VALIDATION_TITLE_EMPTY)
	@Size(max = 50)
	private String title;

	@Size(max = 1000)
	private String message;

	public Notes() {
	}

	public Notes(Long noteId, User userDetails, String title, String message) {
		this.noteId = noteId;
		this.userDetails = userDetails;
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
}
