package com.book.repo;

import com.book.entity.Author;
import com.book.entity.AuthorSearch;
import com.book.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class AutherSpecification implements Specification<Author>{

    private AuthorSearch authorSearch;

    public AutherSpecification(AuthorSearch authorSearch) {
        this.authorSearch = authorSearch;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Join<Author, Book> bookJoin = root.join("books", JoinType.LEFT);
        //authorName
        if (authorSearch.getAuthorName() !=null && !authorSearch.getAuthorName().isEmpty()){
            predicates.add( criteriaBuilder.like(root.get("name"), authorSearch.getAuthorName()));
        }

        //email
        if(authorSearch.getEmail() !=null && !authorSearch.getEmail().isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("email"), authorSearch.getEmail()));
        }
        //IpAddress
        if(authorSearch.getIpAddress() !=null && !authorSearch.getIpAddress().isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("ipAddress"),"%"+ authorSearch.getIpAddress() + "%"));
        }

        //BookName(Join)
        if (authorSearch.getBookName() !=null && !authorSearch.getBookName().isEmpty()) {
            predicates.add(criteriaBuilder.like(bookJoin.get("name"), "%" + authorSearch.getBookName() + "%"));
        }

        //Salary(join Book)
        if(authorSearch.getSalary() !=null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(bookJoin.get("salary"), authorSearch.getSalary()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
