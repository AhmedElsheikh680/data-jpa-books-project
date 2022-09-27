package com.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@NamedEntityGraph(name = "loadAuthor", attributeNodes = @NamedAttributeNode("author"))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double salary;

    @Transient
    private double discount;

    @Formula("(select count(*) from book)")
    private Long bookCount;


    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    public double getDiscount() {
        return discount;
    }

    @PostLoad
    public void calcDiscount() {
        this.setDiscount(salary * .25);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
