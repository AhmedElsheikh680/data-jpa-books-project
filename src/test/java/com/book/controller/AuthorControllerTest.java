package com.book.controller;

import com.book.dto.AuthorDTo;
import com.book.entity.Author;
import com.book.repo.AuthorRepo;
import com.book.service.AuthorService;
import com.book.service.AuthorServiceTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthorControllerTest {

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AuthorService authorService;

//    @MockBean
//    AuthorService authorService;
//    @InjectMocks
//    AuthorService authorService;
//    @Mock
//    AuthorRepo authorRepo;

    @BeforeAll
    void initMethod(){
        log.info("INIT METHOD!!!!!!!!!!!!!!!!!!!!!!");

        Optional<Author> authorParam = Optional.of(new Author("Ahmed", "192.168.1.1", "a@a.com", "0"));
        Mockito.when(authorService.findByEmail(Mockito.anyString())).thenReturn(authorParam);
    }


//    @Test
//    void findByIdNotFoundTest(){
//        Optional<Author> authorParam = Optional.of(new Author("Ahmed", "192.168.1.1", "a@a.com", "0"));
//        Mockito.when(authorService.findByEmail(Mockito.anyString())).thenReturn(authorParam);
//        String email = "ahmed@ahmed.com";
//        ResponseEntity<AuthorDTo> authorDToResponseEntity =
//                restTemplate.getForEntity("/email/"+ email, AuthorDTo.class);
//        Assertions.assertThat(authorDToResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        org.junit.jupiter.api.Assertions.assertEquals(HttpStatus.OK, authorDToResponseEntity.getStatusCode());
//    }



        @Test
        void findByEmailNotFoundTest() throws Exception {
            String email = "test@test.com";
            mockMvc.perform(get("/email/{email}", email)
                    .content("application/json"))
                    .andExpect(status().isOk());

        }

        @Test
    void insertAuthorTest() throws Exception {
            Author author = new Author("ALi", "192.168.1.1", "a@a.com", "0");
            Mockito.when(authorService.save(Mockito.any(Author.class))).thenReturn(author);
            mockMvc.perform(post("/author")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(new Author("ALi", "192.168.1.1", "a@a.com", "0"))))
                    .andExpect(status().isOk());
        }


        @AfterAll
    void destroy(){
        log.info("DESTROY METHOD!!!!!!!!!");
        }
}
