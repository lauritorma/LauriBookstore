package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		@Autowired
		private CategoryRepository crepository;
	
	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories",crepository.findAll());
        return "addbook";
    }     
    
    @PostMapping("/save")
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
    	return "redirect:/booklist";
    }
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId,Long categoryId, Model model) {
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories",crepository.findAll());
    	return "editbook";
    }
    

         
}
