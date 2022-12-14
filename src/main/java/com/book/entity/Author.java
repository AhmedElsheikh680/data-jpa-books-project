package com.book.entity;


import com.book.validator.IpAddress;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners({AuditingEntityListener.class})
@Schema(name = "Author Entity")
public class Author extends BaseEntity<Long> {



    @NotNull
    @NotEmpty(message = "You Must Enter Author Name")
    @NotBlank
    private String fullName;

//    @Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$")
    @IpAddress(message = "Enter Valid ip-address")
    private String ipAddress;

    @Email(message = "{validation.constraints.email.message}")
    private String email;


//    @Formula("(select count(*) from book b where b.author_id = id)")
//    private Long bookCount;

    private String imagePath;


//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Book> books = new ArrayList<>();



    //Create Helper Method (add-delete) instrad of getter wi setter
//    public void addBook(Book book) {
//        books.add(book);
//    }
//
//    public void deleteBook(Book book) {
//        books.remove(book);
//    }
}
