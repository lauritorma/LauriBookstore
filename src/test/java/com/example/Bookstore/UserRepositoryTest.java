package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	 private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = repository.findByUsername("User");
		assertThat(user.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("quest", "$2y$10$xv.Qfz2ciHoSECAu3NSqjuj.Gw4lLRb6IBH361bmMk4cimsM0xLMS","quest@gmail.com","USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void DeleteUser() {
		User user = repository.findByUsername("User");
		repository.delete(user);
		User newUser = repository.findByUsername("User");
		assertThat(newUser).isEqualTo(null);
		
		
	}
}
