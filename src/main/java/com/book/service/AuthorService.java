package com.book.service;


import com.book.entity.Author;
import org.springframework.stereotype.Service;
@Service
public class AuthorService extends BaseService<Author, Long> {

    @Override
    public Author update(Author author) {
      Author author1 =   findById(author.getId());
      author1.setName(author.getName());
        return super.update(author1);
    }
}
