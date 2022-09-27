package com.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@NamedEntityGraph(name = "loadAuthor", attributeNodes = @NamedAttributeNode("author"))
@EntityListeners({AuditingEntityListener.class})
public class Book extends BaseEntity<Long>{

    @NotNull
    @NotEmpty(message = "You Must Enter Book Name")
    @NotBlank
    private String name;

    @Min(value = 5)
    @Max(value = 500)
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

    @NotNull
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
