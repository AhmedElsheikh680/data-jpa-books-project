package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorSearch {

    private String authorName;

    private String email;

    private String ipAddress;

    private String bookName;

    private Double salary;
}
