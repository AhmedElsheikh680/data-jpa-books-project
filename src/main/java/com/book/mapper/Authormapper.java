package com.book.mapper;

import com.book.dto.AuthorDTo;
import com.book.entity.Author;
import org.mapstruct.Mapper;

@Mapper
public interface Authormapper {

    //map from entity to dto
   AuthorDTo mapToDTO(Author entity);

    // map from dto to entity
    Author mapTOEntity(AuthorDTo dto);
}
