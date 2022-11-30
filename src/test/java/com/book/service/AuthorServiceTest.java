package com.book.service;

import com.book.entity.Author;
import com.book.repo.AuthorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @MockBean
    AuthorRepo authorRepo;

    @Test
    void findByEmailNotFoundTest(){
       Optional<Author> authorParam =  Optional.of(new Author("Ahmed", "192.168.1.1", "a@a.com", "0"));
        Mockito.when(authorRepo.findByEmail(Mockito.anyString())).thenReturn(authorParam);
        Optional<Author> author = authorService.findByEmail("aa@a.com");
        Assertions.assertEquals(true, author.isPresent());
        Assertions.assertEquals("a@a.com", author.get().getEmail());
    }
}
