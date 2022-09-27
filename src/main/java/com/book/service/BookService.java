package com.book.service;


import com.book.entity.Book;
import com.book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<Book, Long> {

    @Autowired
    private BookRepo bookRepo;


    public List<Book> saveAll(List<Book> books) {
        return bookRepo.saveAll(books);
    }

    public Book update(Book book) {
        Book book1 = findById(book.getId());
        book1.setName(book.getName());

        return update(book1);
    }


    public int deleteByAuthorId(Long id) {
        return bookRepo.deletebyAuthorId(id);
    }













}
