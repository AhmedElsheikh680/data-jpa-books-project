package com.book.service;


import com.book.entity.Author;
import com.book.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Author findById(Long id) {
        return authorRepo.findById(id).orElseThrow();
    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author save(Author author) {
        if (author.getId() != null) {
            throw  new RuntimeException();
        }
        return authorRepo.save(author);

    }

    public Author update(Author author) {
        Author author1 = findById(author.getId());
        author1.setName(author.getName());

        return authorRepo.save(author1);
    }

    public void delete(Long id) {
         authorRepo.deleteById(id);
    }
















}
