package com.book.repo;

import com.book.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends BaseRepo<Book, Long> {

    @Override
    @EntityGraph(attributePaths = {"author"})
    Optional<Book> findById(Long aLong);

    @Override
    @EntityGraph(value = "loadAuthor")
    List<Book> findAll();

    @Transactional
    @Modifying
    @Query(value = "delete from Book b where b.author.id= :id")
    int deletebyAuthorId(Long id);
}
