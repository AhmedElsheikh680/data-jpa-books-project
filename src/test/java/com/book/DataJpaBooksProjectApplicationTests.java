package com.book;

import com.book.entity.Author;
import com.book.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DataJpaBooksProjectApplicationTests {
	@Autowired
	private AuthorService authorService;

//	@Test
//	void contextLoads() {
//	}

	@Test
	void findByEmailNotFoundTest(){
		Optional<Author> author = authorService.findByEmail("Email@a.com");
		Assertions.assertEquals(false, author.isPresent());
	}

	@Test
	void findByEmailFoundTest(){
		Optional<Author> author = authorService.findByEmail("a@a.com");
		Assertions.assertEquals(true, author.isPresent());
		Assertions.assertEquals("a@a.com", author.get().getEmail());
	}


}
