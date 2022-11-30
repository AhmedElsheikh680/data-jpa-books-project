package com.book.service;


import com.book.entity.Author;
import com.book.entity.AuthorSearch;
import com.book.error.DuplicateRecordException;
import com.book.repo.AutherSpecification;
import com.book.repo.AuthorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class AuthorService extends BaseService<Author, Long> {

    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    @Cacheable(value = "findAllAuthorCache", key = "#root.methodName")
    public List<Author> findAll() {
        return super.findAll();
    }

    @Override
    @Cacheable(value = "findByIdAuthorCache", key = "#id")
    public Author findById(Long id) {
        return super.findById(id);
    }

    @Override
    @CacheEvict(value = "{findAllAuthorCache, findByIdAuthorCache, findByEmailCache}", key = "#root.methodName", allEntries = true)
    public Author save(Author author) {
        if (!author.getEmail().isEmpty() || author.getEmail()!=null) {
//            Optional<Author> author1 = findByEmail(author.getEmail());
            Optional<Author> author1 = findByEmail(author.getEmail());

            logger.info("Author Name Is {} And Email Is {}", author.getFullName(), author.getEmail());
//            if (author1.isPresent()) {
//            if (author1.isDone()) {
//                logger.error("This Email Already Exist!!");
//                throw new DuplicateRecordException("This Email Already Exist!!");
//            }
        }
        return super.save(author);
    }

    @Override
    @CacheEvict(value = "{findAllAuthorCache, findByIdAuthorCache, findByEmailCache}", key="#root.methodName")
    @Caching(evict = {@CacheEvict("author"), @CacheEvict(value = "author", key = "#author.id")})
    public Author update(Author author) {
      Author author1 =   findById(author.getId());
      author1.setFullName(author.getFullName());
        return super.update(author1);
    }

   public List<Author> findByAuthorSpecification(AuthorSearch authorSearch) {
        AutherSpecification autherSpecification = new AutherSpecification(authorSearch);
        return authorRepo.findAll(autherSpecification);
   }

//   public Optional<Author> findByEmail(String email) {
//        return authorRepo.findByEmail(email);
//   }
//    @Async(value = "threadPoolTaskExecutor")
//    @Cacheable(value = "findByEmailCache", key = "#email")
    public Optional<Author> findByEmail(String email) {
//        return CompletableFuture.completedFuture(authorRepo.findByEmail(email).get());
        return authorRepo.findByEmail(email);
    }
}
