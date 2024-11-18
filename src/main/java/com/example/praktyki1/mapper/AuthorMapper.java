package com.example.praktyki1.mapper;

import com.example.praktyki1.dto.AuthorDTO;
import com.example.praktyki1.dto.BookDTO;
import com.example.praktyki1.entity.Author;

import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorDTO toDTO(Author author) {
        if (author == null) return null;

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setNationality(author.getNationality());

        authorDTO.setBooks(author.getBooks().stream()
                .map(book -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setId(book.getId());
                    bookDTO.setName(book.getName());
                    bookDTO.setYear(book.getYear());
                    bookDTO.setPrice(book.getPrice());
                    return bookDTO;
                })
                .collect(Collectors.toList()));

        return authorDTO;
    }
}
