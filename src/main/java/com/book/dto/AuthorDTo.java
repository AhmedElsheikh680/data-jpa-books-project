package com.book.dto;

import com.book.entity.BaseEntity;
import com.book.validator.IpAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTo extends BaseEntity<Long> {

    @NotBlank
    private String name;

    @IpAddress()
    private String ipAddress;

    @Email(message = "{validation.constraints.email.message}")
    private String email;

    private long bookCount;

    private String imagePath;

    private Date createdDate;
}
