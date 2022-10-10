package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	 private BookRepository repository;
	
	
	//in-memory testikirjat merkattu kommenteiksi BookstoreApplication luokkaan, sillä ne aiheuttavat ohjelmaan whitelabel errorin.
	//testiä varten täytyy ottaa kommentit BookstoreApplicationista pois
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("IT");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("King");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Harry Potter", "JK Rowling","1998","0000", "30");
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void DeleteBook() {
		List<Book> books = repository.findByTitle("IT");
		repository.deleteAll(books);
		assertThat(books.get(0).getTitle().isEmpty());
		
		
	}
}
