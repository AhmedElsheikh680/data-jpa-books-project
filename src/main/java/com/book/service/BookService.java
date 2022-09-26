package com.book.service;


import com.book.entity.Book;
import com.book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow();
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book save(Book book) {
        if (book.getId() != null) {
            throw  new RuntimeException();
        }
        return bookRepo.save(book);

    }

    public Book update(Book book) {
        Book book1 = findById(book.getId());
        book1.setName(book.getName());

        return bookRepo.save(book1);
    }

    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
















}
