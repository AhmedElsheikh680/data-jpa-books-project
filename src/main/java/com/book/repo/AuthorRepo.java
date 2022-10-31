package com.book.repo;

import com.book.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends BaseRepo<Author, Long>, JpaSpecificationExecutor<Author>{

    Optional<Author> findByEmail(String email);

//    @Override
//    @EntityGraph(attributePaths = "book")
//    List<Author> findAll();
//
//    @Override
//    @EntityGraph(attributePaths = "book")
//    Optional<Author> findById(Long aLong);
}


