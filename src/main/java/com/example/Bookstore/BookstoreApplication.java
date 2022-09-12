package com.example.Bookstore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book a = new Book("Harry Potter","J.K Rowling", "20", "12345", "2021");
			Book b = new Book("Koiramäki", "Mauri Kunnas", "20", "951114399", "1996" );
			
			repository.save(a);
			repository.save(b);
	 
	};
	}

}