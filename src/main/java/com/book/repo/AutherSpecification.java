package com.book.repo;

import com.book.entity.Author;
import com.book.entity.AuthorSearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
            predicates.add(criteriaBuilder.like(root.get("ipAddress"), authorSearch.getIpAddress()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
