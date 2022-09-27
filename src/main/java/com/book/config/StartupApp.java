//package com.book.config;
//
//import com.book.entity.Author;
//import com.book.entity.Book;
//import com.book.service.AuthorService;
//import com.book.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class StartupApp implements CommandLineRunner {
//
//    @Autowired
//    private AuthorService authorService;
//
//    @Autowired
//    private BookService bookService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        //Adding Some Data For Author
//        Author author = new Author();
//        author.setName("Ahmed");
//
//        Author author2 = new Author();
//        author2.setName("Mohamed");
//
//        Author author3 = new Author();
//        author3.setName("Ali");
//
//        authorService.saveAll(Arrays.asList(author, author2, author3));
//
//        // Adding some data for Book
//        Book book = new Book();
//        book.setName("Spring Boot");
//        book.setSalary(1000.0);
//        book.setAuthor(authorService.getById(1L));
//
//        Book book2 = new Book();
//        book2.setName("Java Se");
//        book2.setSalary(3000.0);
//        book2.setAuthor(authorService.getById(1L));
//
//        Book book3 = new Book();
//        book3.setName("Java Se");
//        book3.setSalary(5000.0);
//        book3.setAuthor(authorService.getById(2L));
//
//        Book book4 = new Book();
//        book4.setName("Java ُُُُُُEE");
//        book4.setSalary(8000.0);
//        book4.setAuthor(authorService.getById(2L));
//
//        bookService.saveAll(Arrays.asList(book, book2, book3, book4));
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//}
