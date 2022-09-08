package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Bookstore.domain.Book;

@Controller
public class BookController {

	@GetMapping("/index")

	public String index(Model model) {
		model.addAttribute("book", new Book()); 
		return "/index";
	}
}
