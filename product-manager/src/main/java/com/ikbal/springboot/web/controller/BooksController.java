package com.ikbal.springboot.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikbal.springboot.web.model.Book;

@RestController
public class BooksController {

	@GetMapping("/books")
	public List<Book> getBooks() {
		return Arrays.asList(new Book(1, "Mastering Spring 2", "Masud"));
	}
}
