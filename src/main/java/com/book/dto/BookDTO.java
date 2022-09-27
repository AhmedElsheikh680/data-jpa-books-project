package com.book.dto;

import com.book.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @Min(value = 5)
    @Max(value = 500)
    private Double salary;

    @NotNull
    private Author author;
}
