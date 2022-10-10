package com.example.Bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			log.info("save some categories for books");
			crepository.save(new Category("IT"));
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Children"));
			crepository.save(new Category("Study"));
			
			//Ohjelmaan tulee whitelabel error, jos tallentaa in-memory kirjoja, mutta testissä toimii. Liittyy jotenkin kategoriaan.
//			log.info("save some books for tests");
//			brepository.save(new Book("IT", "King", "1999", "12345", "20"));
//			brepository.save(new Book("Aapinen", "Aapiskukko", "2005", "121212", "10"));
			
			// Create users: admin/admin user/user
			
			User user1 = new User("User", "$2a$10$mxoLJBX.EsI9uK2.Iflc8..CWyXnjNvYYN2smaQahl2Naw9zwuAFu", "user@gmail.com", "USER");
			User user2 = new User("Admin", "$2a$10$1qPPp5ZsN/fJD/8HjCy0fu/kljuGBk5lVm8n2742Ehxlq2FTdIoAa", "admin@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
	 
	};
	}

}