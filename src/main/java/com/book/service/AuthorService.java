package com.book.service;


import com.book.entity.Author;
import com.book.entity.AuthorSearch;
import com.book.error.DuplicateRecordException;
import com.book.repo.AutherSpecification;
import com.book.repo.AuthorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService extends BaseService<Author, Long> {

    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author save(Author author) {
        if (!author.getEmail().isEmpty() || author.getEmail()!=null) {
            Optional<Author> author1 = findByEmail(author.getEmail());

            logger.info("Author Name Is {} And Email Is {}", author.getName(), author.getEmail());
            if (author1.isPresent()) {
                logger.error("This Email Already Exist!!");
                throw new DuplicateRecordException("This Email Already Exist!!");
            }
        }
        return super.save(author);
    }

    @Override
    public Author update(Author author) {
      Author author1 =   findById(author.getId());
      author1.setName(author.getName());
        return super.update(author1);
    }

   public List<Author> findByAuthorSpecification(AuthorSearch authorSearch) {
        AutherSpecification autherSpecification = new AutherSpecification(authorSearch);
        return authorRepo.findAll(autherSpecification);
   }

   public Optional<Author> findByEmail(String email) {
        return authorRepo.findByEmail(email);
   }
}
