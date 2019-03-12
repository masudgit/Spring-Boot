package com.ikbal.in28minutes;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@GetMapping("/books")
	public List<Book> getBooks() {
		return Arrays.asList(new Book(1, "Mastering Spring", "Masud d ds"));
	}
}
